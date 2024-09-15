// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        // Find the middle of the list
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // If fast is not null, it means it is at the last node.
        // move slow to next node to get the second half of the list
        if(fast != null) {
            slow = slow.next;
        }
        
        // reverse the second half of the List
        ListNode reversed = reverse(slow);
        
        // Compare the two lists one by one while reversed_list does not reach the end
        while(reversed != null) {
            if(reversed.val != head.val) return false;
            
            reversed = reversed.next;
            head = head.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode next = null;
        
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        
        return prev;
    }
    
    private void printList(ListNode node) {
        while(node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println("");
    }
}
