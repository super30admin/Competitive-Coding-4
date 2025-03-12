/*
TC - O(N)
SC - O(1)

Iterative reverse function 
 * 
 */


 class Solution {

    // Helper function to reverse a linked list
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;  // Previous node starts as null
        ListNode current = head;  // Current node starts at head

        while (current != null) {
            ListNode nextNode = current.next; // Store next node
            current.next = prev;  // Reverse the link
            prev = current;  // Move prev forward
            current = nextNode;  // Move current forward
        }

        return prev;  // Return new head of reversed list
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // A single-node or empty list is always a palindrome
        }

        // Step 1: Find the middle of the linked list using slow & fast pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // Moves one step
            fast = fast.next.next;   // Moves two steps
        }

        // Now, `slow` is at the middle of the list (for odd-length, it's the exact middle)
        // For even-length, `slow` is the first node of the second half

        // Step 2: Reverse the second half of the linked list
        ListNode newHead = reverseLinkedList(slow);

        // Step 3: Compare the first half with the reversed second half
        ListNode first = head;  // Pointer for first half
        ListNode second = newHead;  // Pointer for reversed second half

        while (second != null) {  // Compare until second half is fully traversed
            if (first.val != second.val) {
                reverseLinkedList(newHead);  // Restore list before returning
                return false;  // Not a palindrome
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Restore the original list (optional but recommended)
        reverseLinkedList(newHead);

        return true;  // It's a palindrome
    }
}