public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode firstHalf = getFirstHalf(head);
        ListNode reversedSecondHalf = getReverse(firstHalf.next);

        ListNode p1 = head;
        ListNode p2 = reversedSecondHalf;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    private ListNode getFirstHalf(ListNode node) {
        ListNode slowPointer = node;
        ListNode fastPointer = node;

        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    private ListNode getReverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }

        return prev;
    }
}
