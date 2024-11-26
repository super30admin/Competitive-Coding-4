// Time Complexity : O(n/2) + O(n/2) + O(n/2) => O(n) where n is the no.of nodes in LL
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//1. find mid of LL  -> O(n/2)
//2. reverse second half of LL  -> O(n/2)
//3. use two ptrs , one in first half and other in reversed second half ; and check if value at both the ptr matches  -> O(n/2)

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
        // null case
        if (head == null || head.next == null) {
            return true;
        }

        // find mid
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse right half
        slow.next = reverseLL(slow.next);

        slow = slow.next; // moving slow ptr

        // check for palindrome using two ptrs
        ListNode first = head;

        while (slow != null) {
            if (slow.val != first.val)
                return false;

            slow = slow.next;
            first = first.next;

        }
        return true;

    }

    private ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}