// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Our code checks if a singly linked list is a palindrome or not using the two-pointer approach and reversing the second half of the list:
// It first determines the middle of the linked list using slow and fast pointers. Then, it reverses the second half of the linked list.
// Finally, it compares the elements of the first and reversed second half to check for palindrome property. If any pair of elements doesn't match, it returns false; otherwise, it returns true.

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

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode p1 = head;
        ListNode p2 = prev;

        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList obj = new PalindromeLinkedList();

        // Check if the linked list is a palindrome
        boolean isPalindrome = obj.isPalindrome(head);

        // Print the result
        System.out.println("Is the linked list a palindrome? " + isPalindrome);
    }
}
