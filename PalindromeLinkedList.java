// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // find midpoint
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse
        fast = reversed(slow.next);
        slow.next = null;

        slow = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reversed(ListNode head) {
        if (head.next == null)
            return head;
        ListNode prev = reversed(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}