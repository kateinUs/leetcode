package oa;

import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @author huimin
 * @create 2022-09-10 12:25
 */

public class Optiver {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        String input = "(A,B) (A,C) (B,D) (D,C) \n 213";
//        System.out.println(input);
        passInput(input);
    }
    static boolean isUpperCseLetter(char ch){
        return (ch >='A' && ch <='Z');
    }
    static boolean isValidChar(char ch){
        return (ch >='A' && ch <='Z') || ch =='(' || ch ==')' ||ch ==' ' || ch== ',';
    }

    static void passInput(String input){
        HashMap<Character, List<Character>> adjList = new HashMap<>();
        HashMap<Character, Integer> numParents = new HashMap<>();

        boolean E2Error = false;
        boolean E3Error = false;

        Character parent = null;
        Character root = null;

        int index =0; // used to denote parent or child
        for(int i=0; i<input.length(); i++){
            char cur = input.charAt(i);
            if(!isValidChar(cur)){
                System.out.println("E1");
                return;
            }
            // check for leading or trailing space
            if(cur == ' '){
                if(i ==0 || i == input.length()-1){
                    System.out.println("E1");
                    return;
                }else if(input.charAt(i-1) != ')' || input.charAt(i+1) != '('){
                    System.out.println("E1");
                    return;
                }
            }
            if(cur == ','){
                if(i ==0 || i == input.length()-1){
                    System.out.println("E1");
                    return;
                } else if(!isUpperCseLetter(input.charAt(i-1)) || !isUpperCseLetter(input.charAt(i+1))){
                    System.out.println("E1");
                    return;
                }
            }
            if(isUpperCseLetter(cur)){
                index ++;
                if(index % 2 ==1){ // the current char is a parent node
                    if(i>=1 && input.charAt(i-1) != '('){
                        System.out.println("E1");
                        return;
                    } else if(i+1<input.length() && input.charAt(i+1) != ','){
                        System.out.println("E1");
                        return;
                    }

                    parent = cur; // store parent for use in next iteration
                } else {
                    if(i>=1 && input.charAt(i-1) !=','){
                        System.out.println("E1");
                        return;
                    }else if(i+1<input.length() && input.charAt(i+1) !=')'){
                        System.out.println("E1");
                        return;
                    }
                    // check for duplicate (E2)
                    for(int j=0; j<adjList.getOrDefault(parent, new ArrayList<>()).size(); j++){
                        if(adjList.get(parent).get(j) == cur){ // has duplicate
                            E2Error = true;
                        }
                    }

                    // check for parent has more than 2 children (E3)
                    if(adjList.getOrDefault(parent, new ArrayList<>()).size() >= 2){ // the parent already has 2 children
                        E3Error = true;
                    }

                    // update the number of parent in numParent map
                    numParents.put(cur, numParents.getOrDefault(cur, 0)+1);
                    if(!numParents.containsKey(parent)) numParents.put(parent, 0);

                    // else no violation, store the current child node to parent's list
                    ArrayList<Character> list = (ArrayList<Character>)adjList.getOrDefault(parent, new ArrayList<Character>());
                    list.add(cur);
                    adjList.put(parent, list);
                    index = 0; // reset index
                }
            }
        }

        if(E2Error){
            System.out.println("E2");
            return;
        }
        if(E3Error){
            System.out.println("E3");
            return;
        }
        // check for multiple roots (E4)
        int numRoots = 0;
        for(Map.Entry<Character, Integer> entry: numParents.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
            if(entry.getValue() == 0){ // means it the root
                root = entry.getKey();
                numRoots++;
                if(numRoots==2){
                    System.out.println("E4");
                    return;
                }
            }
        }

        // check for cycle (E5) by DFS
        Set<Character> visited = new HashSet<>();
        System.out.println(root);
        if(root != null && DFS(root, '0', visited, adjList)){
            System.out.println("E5");
            return;
        }
         printExpression(adjList, root);

    }

    static boolean DFS(Character node, Character parent, Set<Character> visited, HashMap<Character, List<Character>> adjList){
        visited.add(node);
        for(Character neib: adjList.getOrDefault(node, new ArrayList<Character>())){
            if(!visited.contains(neib)){
                if(DFS(neib, node, visited, adjList)) return true;
            }else if(neib != parent){
                return true;
            }
        }
        return false;
    }

    static void printExpression(HashMap<Character, List<Character>> adjList, char cur){
        System.out.print("(" + cur);
        int numChild = adjList.getOrDefault(cur, new ArrayList<>()).size();
        if(numChild == 1){
            printExpression(adjList, adjList.get(cur).get(0));
        } else if(numChild == 2){
            if(adjList.get(cur).get(0) < adjList.get(cur).get(1)){
                printExpression(adjList, adjList.get(cur).get(0));
                printExpression(adjList, adjList.get(cur).get(1));
            }else{
                printExpression(adjList, adjList.get(cur).get(1));
                printExpression(adjList, adjList.get(cur).get(0));
            }
        }
    }

}
