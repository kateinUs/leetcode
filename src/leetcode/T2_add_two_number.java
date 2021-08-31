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

    /**
     * 1. 首先建立一个新的node表示头，用以指向list头
     * 2. curr为用以遍历的指针，p q表示正在遍历的l1 l2链表中对应的节点，
     *      while循环判断p q是否存在，只要有一个存在则继续遍历，直到
     *      两个指针都指向空，结束循环
     * 3. 最后判断carry是否为1，是则在结果链表后加一个节点，val为1
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers_solution(ListNode l1, ListNode l2) {
        // 初始化，新建一个假头(dummy head)，指向链表头
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while(p != null || q != null){
            int p_val = (p != null)? p.val: 0;
            int q_val = (q != null)? q.val: 0;
            int curr_sum = p_val + q_val + carry;
            carry = curr_sum / 10;
            curr.next = new ListNode(curr_sum % 10);
            curr = curr.next;
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        // 返回的是假头指向的真实的result链表头
        return dummyHead.next;
    }
}
