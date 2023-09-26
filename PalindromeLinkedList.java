// O(n)
//O(1)

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle node
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow.next;
        ListNode prev = null;
        fast = slow.next.next;

        while (fast != null) {
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        current.next = prev;
        slow.next = null;
        slow = head;

        while (current != null && slow != null) {
            if (current.val != slow.val) {
                return false;
            }
            current = current.next;
            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // Create a linked list for testing
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Check if the linked list is a palindrome
        boolean isPalindrome = solution.isPalindrome(node1);

        if (isPalindrome) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
