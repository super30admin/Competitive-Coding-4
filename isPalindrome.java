// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(1)
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
        if(head==null) return true;
        
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode firstEnd = slow;
        ListNode n = firstEnd.next; 
        //Reverse everything after firstEnd
            
        ListNode secondStrt = reverse(n);
            
        //Check for palindrome
        ListNode f = head;
        ListNode s = secondStrt;
        boolean result = true;
        while (result && s != null) {
            if (f.val != s.val) 
                result = false;
            f = f.next;
            s = s.next;
        }        

        // Restore the list
        firstEnd.next = reverse(secondStrt);
        return result;
    }
        
        private ListNode reverse(ListNode head)
        {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
            return prev;
        }
}