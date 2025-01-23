// TC: O(N)
// SC: O(1), where N is the number of nodes in the linked list
// Did it run successfully on Leetcode? : Yes
// Any difficulties faced? : No


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LC234 {
    private ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode x = null, y = head, z = head.next;
        while (y != null) {
            y.next = x;
            x = y;
            y = z;
            if (z != null)
                z = z.next;
        }
        return x;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode part1 = head;
        ListNode part2 = reverseLinkedList(slow.next);
        slow.next = null;
        while (part1 != null && part2 != null) {
            if (part1.val != part2.val)
                return false;
            part1 = part1.next;
            part2 = part2.next;
        }
        return true;
    }
}