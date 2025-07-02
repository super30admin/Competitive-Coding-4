//Time Complexity: O(n)
//Space Complexity: O(1)
//Checks if a singly linked list is a palindrome by reversing the second half of the list.
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if(head == null) return true;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode head1 = head;
        ListNode head2 = prev;

        while(head1 != null && head2 != null) {
            if(head1.val != head2.val) {
                return false;
            }
            else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return true;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}