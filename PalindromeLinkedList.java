/**
 * Time Complexity (TC): O(n) - n - no.of nodes in the Linked List.
 * Space Complexity (SC): O(1)
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find the midpoint of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode second = slow;
        ListNode previous = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = previous;
            previous = second;
            second = temp;
        }

        // Check for palindrome
        ListNode left = head;
        ListNode right = previous;
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
