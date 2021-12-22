// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach

// Used two pointers slow and fast to get the mid
// after getting mid node reversed the list from that point
// check the reversed half with the first half

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
        if (head == null)
            return true;
        ListNode mid = findMid(head);

        ListNode secondhalf = reverseList(mid);
        ListNode first = head;
        ListNode secondFirst = secondhalf;
        while (secondFirst.next != null) {
            if (first.val != secondFirst.val) {
                return false;
            }
            first = first.next;
            secondFirst = secondFirst.next;
        }
        return true;
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode mid) {
        ListNode prev = null;
        ListNode curr = mid;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        return prev;
    }
}