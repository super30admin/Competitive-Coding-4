// Time Complexity : O(N)
// Space Complexity : O(1)

// We first find the mid of LinkedList
// Then we reverse the second half of the linked list
// Now we have 2 LinkedLists. Compare list1 and list2 sequentially.
// If everything matches till end of list1 and list2 then it is palindrome
class Solution2 {
    public boolean isPalindrome(ListNode head) {
        // null checks
        if (head == null)
            return true;

        // find mid
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        // reverse the second half
        ListNode prev = null;
        ListNode curr = mid;
        ListNode tempNext = mid.next;

        while (tempNext != null) {
            curr.next = prev;

            prev = curr;
            curr = tempNext;
            tempNext = tempNext.next;
        }
        curr.next = prev;

        // compare list1 and list2
        ListNode head1 = head;
        ListNode head2 = curr;
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }
}