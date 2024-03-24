// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


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

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
 
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
 
        while (fast != null && fast.next != null) {
             ListNode temp = slow.next;
             fast = fast.next.next;
             slow.next = prev;
             prev = slow;
             slow = temp;
         }
 
         if (fast != null) {
             slow = slow.next;
         }
 
         while (slow != null && prev != null) {
             if (slow.val != prev.val) {
                 return false;
             }
             slow = slow.next;
             prev = prev.next;
         }
 
         return true;
     }
}
