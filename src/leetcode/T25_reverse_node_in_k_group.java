package leetcode;

/**
 * @author huimin
 * @create 2021-07-17 14:51
 */

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class T25 {

    /**
     * Method 1: traversal
     * This method takes 0ms, and 39.2 MB memory. Save time but waste memory
     * First, I calculate the length of the linkedlist given, and calculate the times to reverse the sub-list
     * Then, use 2-cascading for-loop to do the reversion
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup_traversal(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null, next;
        ListNode globalHead = head;

        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        int recursionTime = len/k;
        curr = head;

        ListNode recursionHead = null;
        ListNode preRecursionHead = null;
        for(int i=0; i<recursionTime; i++){
            recursionHead = curr;
            for(int step=0; step<k; step++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if(i == 0){
                globalHead = prev;
            }
            if(preRecursionHead != null){
                preRecursionHead.next = prev;
            }
            preRecursionHead = recursionHead;

        }
        preRecursionHead.next = curr;

        return globalHead;
    }

    /**
     * Method 2: recursion
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup_recursion(ListNode head, int k){
        ListNode curr = head, temp = head, next = null, prev = null;
        int count = 0;

        while (temp != null && count != k) {
            temp = temp.next;
            count++;
        }

        if (count != k) return head;

        while (curr != null && count > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }

        if (next != null) {
            head.next = reverseKGroup_recursion(next, k);
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        int k = 2;
        ListNode res = reverseKGroup_traversal(node1, k);
        System.out.println(res);

        int i = 0;
        boolean flag = true;
        System.out.println(Integer.MIN_VALUE);

    }
}
