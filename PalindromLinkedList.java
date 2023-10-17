//TC will be O(n)
//SC will be O(1)

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // A single node or an empty list is considered a palindrome.
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode secondHalf = reverseLinkedList(slow.next);
        slow.next = null; // Break the list into two halves

        // Step 3: Compare the first and reversed second halves
        ListNode p1 = head;
        ListNode p2 = secondHalf;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false; // Not a palindrome
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // If we reach here, both halves match, and it's a palindrome
        return true;
    }
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Create a linked list for testing
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        PalindromeLinkedList solution = new PalindromeLinkedList();
        boolean result = solution.isPalindrome(node1);

        if (result) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
