package Nov13;

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
    public boolean isPalindrome(ListNode head) {
       
/*
       
     Time Complexity: O(n/2) + O(n/2) + O(n/2) ~= O(n/2)
    
     Space Complexity: O(1)
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
     
     Approach:
     Using fast and slow pointers to reach midpoint of linked list
     NOTE: Reverse second half of the list when fast pointer reaches last element of list or null.
        
*/
        
        // edge
        if (head == null) {
            return true;
        }
        
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode temp = null;
        
        // Time complexity of finding midpt.of linked list: O(n/2)
        // Find mid point of linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; 
        }
        
        ListNode rev = null;
        
        // Time complexity of reversal of one half of linked list: O(n/2)
        // even no.of elements
        if (fast == null) {
            rev = reverse(slow);
        }
        // odd no.of elements
        else {
            rev = reverse(slow.next);
        }
        
        // Time complexity of comparisons of the two halves of the linked list: O(n/2)
        // comparing elements of first half and reversed second half linked list
        while (head != null && rev != null) {
           if (head.val != rev.val) {
               return false;
           }
           head = head.next;
           rev = rev.next;
        }
        
        return true;
        
    }
    
    // helper function to reverse the list 
    public ListNode reverse(ListNode head) {
            
        ListNode pre = null;
    
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        
        return pre;
        
    }
}