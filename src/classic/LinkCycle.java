package classic;


import java.util.HashSet;
import java.util.Set;

/**
 * @author huimin
 * @create 2021-07-27 17:57
 */
public class LinkCycle {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        node5.next = node3;

        System.out.println(hasCycle2(node1));


    }

    // 时间复杂度 O(N) 空间复杂度 O(N)
    public static boolean hasCycle(ListNode head){

        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 双指针方法 快慢指针
    public static boolean hasCycle2(ListNode head){

        if(head == null)
            return false;
        ListNode slow = head;
        ListNode quick = head.next;

        while (slow != quick){
            if(quick == null || quick.next == null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }

        return true;
    }
}
