// Time Complexity : O(N) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

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
        
        if(head == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        ListNode prev = null;
        ListNode curr = head2;
        ListNode temp;
        
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        head2 = prev;
        
        while(head != null & head2 != null) {
            if(head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        
        return true;
        
        }
 
}