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
class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy;
    // Finding the middle of the linked list.
    while(fast!=null && fast.next!=null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode prev = null;
    ListNode current = slow.next;
    // Reversing the second half of the list.
    while(current!=null) {
      ListNode temp = current.next;
      current.next = prev;
      prev = current;
      current = temp;
    }
    slow.next = null; // Spliting the list into two halves.

    ListNode first = head;
    ListNode second = prev;
    // Checking if the corresponding value of nodes on both halves match.
    while(second!=null) {
      if(first.val!=second.val) return false;
      first = first.next;
      second = second.next;
    }
    return true;
  }
}