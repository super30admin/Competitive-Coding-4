// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        
        // FInd the middle point of the list
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow points to the start of the later half in case of even nodes
        // But to move slow to the start of the later half for odd nodes, we have to do slow = slow.next
        if (fast != null) {
            slow = slow.next;
        }
        
        ListNode reversed = reverseList(slow);
        
        // now Traverse both the head and reversed to check if the values match untill reversed becomes null
        
        while (reversed != null) {
            if (reversed.val != head.val) {
                return false;
            }
            
            reversed = reversed.next;
            head = head.next;
        }
        
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        
        ListNode next = null;
        ListNode prev = null;
        
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
}