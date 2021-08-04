package leetcode;

/**
 * @author huimin
 * @create 2021-07-31 22:28
 */
public class T2_add_two_number {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0, sum = 0;
        ListNode last = null, head = null, cur = null;
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry;
            cur = new ListNode(sum % 10);

            if(last != null){
                last.next = cur;
            } else{
                head = cur;
            }
            last = cur;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            sum = l1.val + carry;
            cur = new ListNode(sum % 10);
            if(last != null){
                last.next = cur;
            }
            last = cur;
            carry = sum / 10;
            l1 = l1.next;
        }

        while(l2 != null){
            sum = l2.val + carry;
            cur = new ListNode(sum % 10);
            if(last != null){
                last.next = cur;
            }
            last = cur;
            carry = sum / 10;
            l2 = l2.next;
        }
        if(carry > 0)
            last.next = new ListNode(1);
        return head;
    }
}
