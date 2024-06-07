// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * To check whether the list is palindrome, we split the list and reverse
 * the second half first. Once done, we traverse 2 pointers, one from start and
 * one from mid, and check if all elements are same, and if so, the list is a
 * palindrome.
 */

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
        // find mid
        // reverse list from mid
        // traverse from both start and mid and see if anything is diff

        if(head == null || head.next == null) return true; // single node is a palindrome

        ListNode ptr = head;
        ListNode mid = head;
        while(ptr != null && ptr.next != null) {
            mid = mid.next;
            ptr = ptr.next.next;
        }

        mid = reverseList(mid);

        ptr = head;
        ListNode ptr1 = mid;
        while(ptr1 != null) {
            if(ptr.val != ptr1.val) {
                return false;
            }
            ptr = ptr.next;
            ptr1 = ptr1.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        // single node doesn't need to be reversed
        if(head == null || head.next == null) return head; 

        ListNode prev = null; 
        ListNode curr = head;
        ListNode next = head.next;

        while(next != null) {
            curr.next = prev; // reverse this link
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev; // need to reverse that last link which was left out
        return curr;
    }
}