//Time Complexity: O(n)
//Space Complexity: O(1)
//Approach: the elements in a linked list will be palindrome if they are the mirror image of each other from the middle to the left
//and from the middle to the right. Taking this into consideration, we find the middle of the linked list, reverse the second portion
//and compare the elements of the left and right until the right linked list gets exhausted (will be smaller or equal in size to the left)
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while (fast != null && slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverse(ListNode fast) {
        ListNode prev = null, current = fast;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        final PalindromeLinkedList linkedList = new PalindromeLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(linkedList.isPalindrome(head)); //return true

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));
        System.out.println(linkedList.isPalindrome(head)); //return true

        head = new ListNode(1, new ListNode(2));
        System.out.println(linkedList.isPalindrome(head)); //return false
    }
}
