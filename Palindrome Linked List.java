// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        
        // check if only one node present
        if(head.next == null) return true;
        
        // initialize the pointers
        ListNode slow = head;
        ListNode fast = head;
        
        // finding the mid element
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        // reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = head2;
        ListNode fast2 = head2.next;
        
        while(fast2 != null){
            curr.next = prev;
            prev = curr;
            curr = fast2;
            fast2 = fast2.next;
        }
        curr.next = prev;
        
        // make the curr element of the reversed list as head2 
        head2 = curr;
        
        // iterating through both the list 
        while(head != null && head2 != null){
            // if values are different, then return false
            if(head.val != head2.val){
                return false;
            }
            
            // else move forward
            head = head.next;
            head2 = head2.next;
        }
        
        return true;
    }
}