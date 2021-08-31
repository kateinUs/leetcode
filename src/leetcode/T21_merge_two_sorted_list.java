package leetcode;

/**
 * @author huimin
 * @create 2021-08-27 1:59
 */
public class T21_merge_two_sorted_list {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sudoHead = new ListNode(0);
        ListNode curr = sudoHead;
        while(l1 != null & l2 != null){
            if(l1.val > l2.val){
                curr.next = l2;
                l2 = l2.next;
            } else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null)? l2: l1;

        return sudoHead.next;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(3);
        ListNode l1 = new ListNode(2, l2);
        ListNode l4 = new ListNode(6);
        ListNode l3 = new ListNode(5,  l4);
        ListNode res = mergeTwoLists(l1, l3);

    }
}
