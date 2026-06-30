// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// - Use slow and fast pointers to find the middle of the linked list.
// - Reverse the second half of the list starting from the middle.
// - Compare nodes from both ends until reaching the middle.

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        //find middle
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        ListNode prev = mid, current = prev.next;
        //reverse
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode start = head, end = prev;
        while(start != mid) {
            if(start.val != end.val) {
                return false;
            }
            start = start.next;
            end = end.next;
        }

        return true;
    }
}