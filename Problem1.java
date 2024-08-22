//Time = O(n)
//SPace= O(n)

class Solution {
    public boolean isPalindrome(ListNode head) {
        // Step 1: Create a reversed copy of the linked list
        ListNode reversedHead = reverseAndClone(head);
        
        // Step 2: Compare the original linked list with the reversed copy
        return isEqual(head, reversedHead);
    }
    
    // Helper function to reverse the linked list and create a new reversed list
    private ListNode reverseAndClone(ListNode head) {
        ListNode prev = null;
        
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = prev;
            prev = newNode;
            head = head.next;
        }
        
        return prev;
    }
    
    // Helper function to compare two linked lists for equality
    private boolean isEqual(ListNode one, ListNode two) {
        while (one != null && two != null) {
            if (one.val != two.val) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        
        return one == null && two == null;
    }
}