package leetcode;

/**
 * @author huimin
 * @create 2022-02-20 1:30
 */
public class T19_Remove_nth_node_from_end_of_list {
    // one pass solution
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // the first pointer is n+1 step faster than second
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=1; i<=n+1; i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;

    }
}
