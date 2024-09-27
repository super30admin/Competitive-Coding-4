// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // middle
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse
        ListNode prev = null;
        ListNode nextPtr = slow.next;
        while(nextPtr != null) {
            ListNode temp = nextPtr.next;
            nextPtr.next = prev;
            prev = nextPtr;
            nextPtr = temp;
        }
        
        ListNode curr = head;
        while(curr != null && prev != null) {
            if(curr.val != prev.val)
                return false;
            curr = curr.next;
            prev = prev.next;
        }
        return true;
    }
}