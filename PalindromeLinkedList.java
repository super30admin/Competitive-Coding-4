/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class PalindromeLinkedLsit {
    public boolean isPalindrome(ListNode head) {

        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = head2;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;

        while (head != null && head2 != null) {
            if (head.val != head2.val)
                return false;
            else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;

    }

}

// TC: O(n) SC: O(1)