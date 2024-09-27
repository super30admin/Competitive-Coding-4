// Time Complexity - O(n)
// Space Complexity - O(1)

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
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Find the middle and only compare the second half
        if(head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow;
        slow = null;
        slow = head;

        // Reverse the second list which has fast as its head
        ListNode prev = null;
        ListNode curr = fast;
        if(fast == null){
            if(head.val != head.next.val){
                return false;
            }
            else{
                return true;
            }
        }
        ListNode nexty = fast.next;

        while(nexty != null){
            curr.next = prev;
            prev = curr;
            curr = nexty;
            nexty = nexty.next;
        }

        curr.next = prev;

        // Now iterate over the second half which has curr as my head and compare it with first half

        while(curr!=null){
            if(curr.val!=slow.val){
                return false;
            }
            curr = curr.next;
            slow = slow.next;
        }

        return true;



    }
}