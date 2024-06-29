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

// Time Complexity : o(N)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yES
// Any problem you faced while coding this : No


class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head; 
        while(fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        } // splitting ll in half
        ListNode prev = slow;
        slow = slow.next; // pointer at half + 1
        prev.next = null;
        while(slow!=null) { // reverse iteration of ll
            ListNode temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
        }
        while(prev!=null) {
            if(prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}