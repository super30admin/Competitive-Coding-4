/*The time complexity of this implementation is O(n) and
* space complexity is O(n)*/
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            // A list with 0 or 1 nodes is always a palindrome.
            return true;
        }

        // Find the middle of the list using slow and fast pointers.
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list.
        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare the first half of the list with the reversed second half.
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
        // Create a linked list for testing purposes
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        PalindromeLinkedList solution = new PalindromeLinkedList();
        boolean isPalindrome = solution.isPalindrome(head);
        System.out.println(isPalindrome);
    }

}
