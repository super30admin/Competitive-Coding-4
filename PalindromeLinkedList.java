// Approach: Reverse second half of the linked list and compare
// Time: O(N)
// Space: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // Reverse the second half of the list
        ListNode reversePointer = reverse(slowPointer.next);

        // Compare first half and reversed second half
        while (reversePointer != null) {
            if (head.val != reversePointer.val) {
                return false;
            }
            head = head.next;
            reversePointer = reversePointer.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode previousPointer = null;
        while (node != null) {
            ListNode nextPointer = node.next;
            node.next = previousPointer;
            previousPointer = node;
            node = nextPointer;
        }
        return previousPointer;
    }
}