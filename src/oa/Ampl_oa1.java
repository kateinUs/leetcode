package oa;

import leetcode.ListNode;



/**
 * @author huimin
 * @create 2022-02-22 14:48
 */
public class Ampl_oa1 {
    public ListNode reverseHeadWithKthNode(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head; // dummy.next store the old head
        ListNode pre = dummy;
        for(int i=0; i<k; i++){
            pre = head;
            head = head.next;
        }
        ListNode kthNode = head;
        pre.next = dummy.next;
        kthNode.next = dummy.next.next;
        dummy.next = kthNode;
        dummy.next.next = kthNode.next;

        return dummy.next;
    }
}
