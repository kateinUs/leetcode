package meta;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huimin
 * @create 2021-11-30 14:07
 */
public class Node_in_a_Subtree {
    // Tree Node
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Query {
        int u;
        char c;
        // u: val of node
        // character associated to the node
        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    // Add any helper functions you may need here


    private int getCount(Node node, Query q, String s){
        if(node==null){
            return 0;
        }
        int count=0;
        if(s.charAt(node.val-1)==q.c){
            count++;
        }
        for(Node child: node.children)
            count+=getCount(child,q,s);
        return count;
    }

    private Node findNode(Node root, int val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        for(Node child: root.children){
            Node found = findNode(child, val);
            if(found!=null){
                return found;
            }
        }
        return null;
    }

    int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        int[] result = new int[queries.size()];
        int i=0;
        for(Query q: queries){
            Node node = findNode(root, q.u);
            result[i++]=getCount(node, q, s);
        }
        return result;
    }

}
