// O(n) time, O(1) space
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }
        int mid = len/2;

        for (int i = 0; i < mid; i++) {
            slow = slow.next;
        }

        if (len % 2 == 0) {
            fast = reverse(slow);
        }
        else {
            fast = reverse(slow.next);
        }

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

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}