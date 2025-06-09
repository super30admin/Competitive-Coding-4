// Time Complexity O(n)
// Space Complexity O(1)
// Runs on Leetcode YES
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
class PalindromLL {
    ListNode mid;
    ListNode revesedHead;
    boolean flag =  true;
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // find mid
        while(fast.next !=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;
        // reversed sencond half
        revesedHead = reverse(mid);

        while(head!= null && revesedHead != null ){
            if( head.val != revesedHead.val){
                return false;
            }
            head = head.next;
            revesedHead =revesedHead.next;
        }
        return true;
    }

    private ListNode reverse( ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev=head;
            head = next;
        }
        return prev;
    }
}
