/*
Time COmplexity -. O(N)
Space COmplexity -> O(1)
*/


class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;

    }

    private ListNode reverse(ListNode temp) {
        ListNode prev = null;
        ListNode curr = temp;
        ListNode next1 = temp.next;
        while (next1 != null) {
            curr.next = prev;
            prev = curr;
            curr = next1;
            next1 = next1.next;
        }
        curr.next = prev;
        return curr;
    }
}