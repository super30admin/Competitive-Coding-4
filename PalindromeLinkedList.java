/**
 * TC - O(n) where n is total numebr of nodes
 * SC - O(1)
 */
public class PalindromeLinkedList {
    public class ListNode {
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

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;

        slow.next = null;

        ListNode prev = null, next = curr.next;

        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;

        ListNode first = head;

        while (curr != null) {
            if (curr.val != first.val) {
                return false;
            }
            curr = curr.next;
            first = first.next;
        }

        return true;
    }
}
