// https://leetcode.com/problems/palindrome-linked-list

// Time Com: O(n)
// Space Com: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        // Null case
        // if(head == null) return false;
        
       while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        
        slow = reverseLL(slow);
        fast = head;
        
        while(slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}