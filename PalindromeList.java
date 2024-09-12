// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while(fast != null) {
            if(slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;
        
        ListNode prev = null, fast = node.next;
        
        while(fast != null) {
            node.next = prev;
            prev = node;
            node = fast;
            fast = fast.next;
        }
        
        node.next = prev;
        return node;
    }
}