// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the linked list using slow and fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // Compare the first and second halves of the linked list for palindrome
        ListNode left = head;
        ListNode right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
