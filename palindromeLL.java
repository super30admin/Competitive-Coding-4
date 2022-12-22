// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
 * Divide LL in 2 parts, reverse the 2nd part and compare the 1st part and 2nd reverse 2nd part
*/

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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        // dividing the LL

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse
        ListNode current = slow.next;
        ListNode prev = null;
        fast = current.next;
        slow.next = null;
        while (current.next != null) {
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        current.next = prev;

        // compare
        slow = head;

        while (slow != null && current != null) {
            if (slow.val != current.val)
                return false;

            slow = slow.next;
            current = current.next;
        }

        return true;
    }

}