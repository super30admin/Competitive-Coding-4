// TC - O(n)
// SC - O(1)
// Approach - Find the middle element. Iterate over the second half of the LL and reverse the LL. Now compare the right reversed LL with the first half and verify if they are palindromic or not. 
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

        ListNode left = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            fast = fast.next;
        }
        if (slow.next != null) {
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode curr = slow; // 2

        while (curr != null) {
            ListNode temp = curr.next; // 1
            curr.next = prev; // 2->null
            prev = curr; // 2
            curr = temp; //

        }

        while (prev != null) {
            if (left.val != prev.val) {
                return false;
            }
            prev = prev.next;
            left = left.next;
        }
        return true;
    }
}