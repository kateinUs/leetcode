package leetcode;

/**
 * @author huimin
 * @create 2021-07-22 14:06
 */
public class ReverseLinkedList {

    public static ListNode recursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode new_head = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode res = recursion(node1);

    }
}
