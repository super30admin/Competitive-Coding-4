// Time Complexity : O(n) where n is the number of nodes in the linked list, as we need to traverse the list twice (once to find the middle and once to compare the halves).
// Space Complexity : O(1) as we are using only a constant amount of extra space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// I understood that i need to find the middle of the linked list, 
// reverse the second half of the list and then compare both halves of the list to check if they are equal or not.
//  If they are equal then the linked list is a palindrome, otherwise it is not.
//  I used the fast and slow pointer technique to find the middle of the linked list and then reversed the second half of the list using a helper function. 
// Finally, I compared both halves of the list and returned true if they are equal, otherwise false.


/**
 * Definition for singly-linked list node.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        // find middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        slow.next = reverseList(slow.next);
        slow = slow.next;

        // compare both halves
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}