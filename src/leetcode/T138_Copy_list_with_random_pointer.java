package leetcode;

import java.util.HashMap;

/**
 * @author huimin
 * @create 2022-02-07 15:13
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class T138_Copy_list_with_random_pointer {
    // value is old node, and value is the corresponding new value
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        if(visitedHash.containsKey(head))
            return visitedHash.get(head);
        Node node = new Node(head.val);
        visitedHash.put(head, node);

        // end when head's next is null
        node.next = copyRandomList(head.next);
        //当上一行递归结束后，hash表里包括了所有的新节点，random递归的时候会直接return新建的节点
        node.random = copyRandomList(head.random);
        return node;
    }
}
