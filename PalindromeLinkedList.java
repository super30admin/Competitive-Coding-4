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

/**
 * Time Complexity: O(N) where N is the number of nodes in the Linked List
 * Space Complexity: O(1)
 * LeetCode: Y (https://leetcode.com/problems/palindrome-linked-list/)
 * Approach: Reverse the second half of the LinkedList
             Compare the elements one by one in both the halves
             Reverse the second half again
             If all elements are equal then return true else return false
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean isLLPalindrome = true;
        
        // if the linked list is empty or has one node then the given linked list is a palindrome
        if(head == null || head.next == null) {
            return isLLPalindrome;
        }
        
        // get the middle of the linked list
        ListNode endOfFirstHalf = getMiddleNode(head);
        
        // reverse the second half of the Linked List
        ListNode headOfReversedSecondHalf = reverseLinkedList(endOfFirstHalf.next);
        
        // Use two pointers: current1, current2
        // current1 traverses the first half one node at a time
        // current2 traverses the second half one node at a time
        ListNode current1 = head, current2 = headOfReversedSecondHalf;
        
        // Iterate both the halves
        while(current2 != null) {
            // Compare val of current1 and current2 
            // If there is a mismatch then the Linked List is not a palindrome
            if(current1.val != current2.val) {
                isLLPalindrome = false;
                break;
            }
            
            // Move current1 forward
            current1 = current1.next;
            
            // Move current2 forward
            current2 = current2.next;
        }
        
        // reverse the second half to restore the original Linked List
        endOfFirstHalf.next = reverseLinkedList(headOfReversedSecondHalf);
        
        // return the result
        return isLLPalindrome;
    }
    
    // Helper function to get the Middle Node of the Linked List
    // If the Linked List is 1 -> 2 -> 3 -> 4 -> 5 the function returns 3
    // If the Linked List is 1 -> 2 -> 3 -> 4 -> 5 -> 6 the function returns 4
    private ListNode getMiddleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head, fast = head;
        
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    // Helper function to reverse the Linked List
    private ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, temp = null, current = head;
        
        while(current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
    }
}
