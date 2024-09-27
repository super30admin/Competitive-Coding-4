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
class PalindromeLinkedList {
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Reach the middle and the end of the linked list using the slow and fast pointers
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //When the length of linked list is odd, then we skip the middle and move the slow ahead
        if(fast != null)
            slow = slow.next;
        
        // Reverse the right half of the linked list
        slow = reverse(slow);
        fast = head;

        // Now compare the left half and the reversed right half of the linked list. If any value does not match - then return false else true
        while(slow != null){
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    // Code to reverse a linked list
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}