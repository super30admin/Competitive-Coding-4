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

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Reach mid of linkedlist using fast-slow pointer approach. Reverse the linkedlist from the mid. Maintain 2 pointers at the start of original
 * linkedlist and reversed linkedlist. Iterate over the linkedlist and check nodes at both pointer in each iteration. If the nodes are not
 * same, return false. If all nodes are same, then it is a palindrome. Return true.
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = reverse(slow.next);

        slow = head;

        while(fast != null) {
            if(fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}