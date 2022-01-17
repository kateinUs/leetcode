package meta;

/**
 * @author huimin
 * @create 2021-11-30 13:43
 */
public class Number_of_Visible_Nodes {
    class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Add any helper functions you may need here


    int visibleNodes(Node root) {
        // Write your code here
        return level_dfs(root, 1);
    }

    int level_dfs(Node node, int level){
        if(node == null) return 0;
        if(node.left == null && node.right == null)
            return level;

        return Math.max(level_dfs(node.left, level+1), level_dfs(node.right, level+1));
    }

    public void test1(){
        Node root_1 = new Node(8);
        root_1.left = new Node(3);
        root_1.right = new Node(10);
        root_1.left.left = new Node(1);
        root_1.left.right = new Node(6);
        root_1.right.right = new Node(14);
        root_1.left.right.left = new Node(4);
        root_1.left.right.right = new Node(7);
        root_1.right.right.left = new Node(13);
        int expected_1 = 4;
        int output_1 = visibleNodes(root_1);
        System.out.println(output_1 == expected_1);
    }

    public void test2(){
        Node root_2 = new Node(10);
        root_2.left = new Node(8);
        root_2.right = new Node(15);
        root_2.left.left = new Node(4);
        root_2.left.left.right = new Node(5);
        root_2.left.left.right.right = new Node(6);
        root_2.right.left = new Node(14);
        root_2.right.right = new Node(16);

        int expected_2 = 5;
        int output_2 = visibleNodes(root_2);
        System.out.println(output_2 == expected_2);
    }
    public static void main(String[] args) {
        Number_of_Visible_Nodes test = new Number_of_Visible_Nodes();
//        test.test1();
//        test.test2();
        String s1 = "asdhe";
        String s2 = "aabbc";
        System.out.println(s2.compareTo(s1));
    }

}
