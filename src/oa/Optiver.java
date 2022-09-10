package oa;

import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @author huimin
 * @create 2022-09-10 12:25
 */

public class Optiver {

    HashMap<Character, List<Character>> adjList = new HashMap<>();
    HashMap<Character, Integer> numParents = new HashMap<>(); // map of all nodes to number of parents, used for check E4/5
    Character root;
    Set<Character> visited;
    static boolean isUpperCaseLetter(char ch){
        return (ch >= 'A' && ch <= 'Z');
    }
    static boolean isValidChar(char ch){
        return (ch >= 'A' && ch <= 'Z') || ch == '(' || ch == ')' || ch == ',' || ch == ' ';
    }
    void method(String input){
        Character parent = null;
        int index = 0;

        for(int i=0; i<input.length(); i++){
            char cur = input.charAt(i);
            if(!isValidChar(cur)){
                System.out.println("E1");
                return;
            }
            // leading or tailing 0 or 2 consecutive 0
            if(cur == ' '){
                if(i== 0 || i == input.length()-1){
                    System.out.println("E1");
                    return;
                }else if(input.charAt(i-1) != ')' || input.charAt(i+1) != '('){
                    System.out.println("E1");
                    return;
                }
            }
//            if((i == 0 && cur == ' ') || (i == input.length()-1 && cur == ' ') || (i >= 1&& cur == ' ' && input.charAt(i-1) == ' ')){
//                System.out.println("E1");
//                return;
//            }
            if(cur == ',' ){
                if(i== 0 || i == input.length()-1){
                    System.out.println("E1");
                    return;
                }else if(!isUpperCaseLetter(input.charAt(i-1)) || !isUpperCaseLetter(input.charAt(i+1))){
                    System.out.println("E1");
                    return;
                }
            }
            if(cur >= 'A' && cur <= 'Z'){
                index++;
                if(index % 2 ==1){ // input[i] is a parent node
                    if(i-1 >= 0 && input.charAt(i-1) != '('){
                        System.out.println("E1");
                        return;
                    } else if(i+1 <input.length() && input.charAt(i+1) != ','){
                        System.out.println("E1");
                        return;
                    }
                    // store parent for use in next iteration
                    parent = cur;
                } else{
                    if(i -1>=0 && input.charAt(i-1) != ','){
                        System.out.println("E1");
                        return;
                    } else if(i+1 < input.length() && input.charAt(i+1) != ')'){
                        System.out.println("E1");
                        return;
                    }

                    // check duplicate (E2)
                    for(int j=0; j<adjList.getOrDefault(parent, new ArrayList<>()).size(); j++){
                        if(adjList.get(parent).get(j) == cur){
                            System.out.println("E2");
                            return;
                        }
                    }

                    // check for parent has more than 2 children (E3)
                    if(adjList.getOrDefault(parent, new ArrayList<>()).size() == 2){ // the parent already had 2 children
                        System.out.println("E3");
                        return;
                    }

                    // update the parent number in map
                    numParents.put(cur, numParents.getOrDefault(cur, 0)+1);
                    if(!numParents.containsKey(parent)) numParents.put(parent, 0);

                    // else no violation, store the node to parent's adjList
                    ArrayList<Character> list = (ArrayList<Character>) adjList.getOrDefault(parent, new ArrayList<Character>());
                    list.add(cur);
                    adjList.put(parent, list);
                    index = 0;

                }
            }
        }

        // multiple root check (E4)
        int numRoots = 0;
        for(Map.Entry<Character, Integer> entry: numParents.entrySet()){
            if(entry.getValue() == 0){
                root = entry.getKey();
                numRoots++;
                if(numRoots == 2){
                    System.out.println("E4");
                    return;
                }
            }
        }

        // check tree cycle (E5) by DFS
//        boolean E5Error = false;
        visited = new HashSet<>();
//        for(Character node: adjList.keySet()){
//            visited = new HashSet<>();
//            E5Error = DFS(node);
//            if(E5Error) break;
//        }
        if(root != null && DFS(root, '0')){
            System.out.println("E5");
        }
    }

    boolean DFS(Character node, Character parent){
        visited.add(node);

        for(Character neib: adjList.getOrDefault(node, new ArrayList<>())){
            if(!visited.contains(neib)) {
                if (DFS(neib, node)) return true;
            }else if(neib != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "(A,B) (A,C) (B,D) (D,C)";
        String input2 = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";
        Optiver test = new Optiver();
        Optiver test2 = new Optiver();
        test.method(input);
        test2.method(input2);

    }
}
