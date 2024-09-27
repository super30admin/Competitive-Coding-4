// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//234. Palindrome Linked List
//https://leetcode.com/problems/palindrome-linked-list/


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
    // time:O(n)
    // space: O(1)
    public boolean isPalindrome(ListNode head) {
        boolean flag = true;
        if (head == null)
            return false;
        if (head.next == null)
            return true;

        // finding the middle of the element
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half of the list
        ListNode temp = slow.next;
        slow.next = null;

        fast = temp.next;
        temp.next = null;
        while (fast != null) {
            ListNode x = fast.next;
            fast.next = temp;
            temp = fast;
            fast = x;
        }

        // checking if first half and second half of the list matches
        slow = head;
        if (fast == null)
            fast = temp;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow = slow.next;
                fast = fast.next;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}