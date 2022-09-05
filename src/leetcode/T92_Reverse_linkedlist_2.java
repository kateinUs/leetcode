package leetcode;

/**
 * @author huimin
 * @create 2022-02-22 23:16
 */
public class T92_Reverse_linkedlist_2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            // You can also expand the code here to get rid of the helper function 'reverseN'
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);

        return head;
    }
    ListNode successor = null;
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
