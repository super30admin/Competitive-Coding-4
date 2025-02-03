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

// TC: O(1) as no extra space is used apart from ListNode itself.
// SC: O(h) where h is the height of recursion stack. which is used for
// reversing the list
public class PalindromeLinkedList {
    static int glength;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2, new ListNode(1));
        System.out.println(isPalindrome(head)); // true

        System.out.println(isPalindrome(new ListNode(1, new ListNode(2)))); // false
    }

    // My approach is to calculate the length of the list first. And compare the
    // second half with the original first
    // half. If same, then return true otherwise false
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        ListNode dummy = head;
        glength = 0;
        while (dummy != null) {
            glength++;
            dummy = dummy.next;
        }

        int count = 1;
        dummy = head;
        while (count < glength / 2 + 1) {
            dummy = dummy.next;
            count++;
        }
        ListNode reversed = halfReverse(dummy);
        ListNode original = head;
        while (reversed != null) {
            if (reversed.val != original.val)
                return false;
            reversed = reversed.next;
            original = original.next;
        }
        return true;
    }

    // Reversing the second half of the list.
    private static ListNode halfReverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = halfReverse(head.next);
        head.next.next = head;
        head.next = null;
        return current;
    }
}
