/*
Time Complexity: O(n) where n is the number of nodes in the linked list.
Space Complexity: O(1) since we are not using any extra space except for a few variables.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: The idea is to find the middle of the linked list using the slow and fast pointer technique,
*/

public class LinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // base
        if (head == null)
            return true;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = reverseList(slow);
        slow.next = null;
        ListNode l1 = head;
        while (l2 != null) { // l1 != null
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
