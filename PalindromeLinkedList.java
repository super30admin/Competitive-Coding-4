// Time Complexity : O(n), where n is the number of nodes in the list
// Space Complexity : O(1), since we only use pointers and reverse the list in-place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// 1) Use slow & fast pointers to find the middle of the linked list.
//    - If the length is odd, slow stops at the middle; if even, slow stops at the end of the first half.
// 2) Reverse the second half of the list.
// 3) Compare the first half and the reversed second half node by node.
// 4) If all nodes match, it's a palindrome; otherwise, return false.

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        // Step 1: Find the middle using slow & fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Determine start of second half
        // If odd length -> slow is middle, second half starts at slow.next
        // If even length -> slow is already start of second half
        ListNode sec = (fast == null) ? slow : slow.next;

        // Step 3: Reverse second half
        ListNode reverse = reverse(sec);

        // Step 4: Compare first half and reversed second half
        ListNode p1 = head, p2 = reverse;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        // Test case 1: Palindrome list [1, 2, 2, 1]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        PalindromeLinkedList sol = new PalindromeLinkedList();
        System.out.println("Is [1, 2, 2, 1] a palindrome? " + sol.isPalindrome(head1));

        // Test case 2: Not a palindrome [1, 2, 3]
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println("Is [1, 2, 3] a palindrome? " + sol.isPalindrome(head2));

        // Test case 3: Palindrome with odd length [1, 2, 3, 2, 1]
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(2);
        head3.next.next.next.next = new ListNode(1);

        System.out.println("Is [1, 2, 3, 2, 1] a palindrome? " + sol.isPalindrome(head3));
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
