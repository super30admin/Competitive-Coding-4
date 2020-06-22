// Time Complexity : O(n) --> where n is number of nodes in linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (234): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        
        // to get the mid-point in the list  
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        slow.next = null;
        slow = head;
        
        // reverse the second half of the list
        ListNode prev = null;
        ListNode Nxt = fast.next;
        while (fast != null) {
            fast.next = prev;
            prev = fast;
            fast = Nxt;
            if (Nxt != null) Nxt = Nxt.next;
        }
        fast = prev;
        
        // start compare 1st node of both the list till end
        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;   
    }
}