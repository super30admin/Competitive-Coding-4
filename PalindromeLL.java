/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Time Complexity : O(n), n=nodes of LL
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        // finding middle to split the LL
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next; // head2 start of the secodn half of the list as a new list.
        slow.next = null;

        // Reversing the second half of the list
        ListNode prev = null;
        ListNode curr = head2;
        ListNode fast2;

        while (curr != null) {
            fast2 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fast2;

        }
        head2 = prev;

        // compare both the lists, if they have same elements, then a palindrome
        while (head != null && head2 != null) {
            if (head.val != head2.val)
                return false; // not a palindrome
            else {
                head = head.next; // move to comoare the next elements
                head2 = head2.next;
            }
        }
        return true;

    }
}