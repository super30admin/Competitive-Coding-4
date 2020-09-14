// Time Complexity : O(n/2+n/2+n/2) = O(n)
// Space Complexity : O(1) since it is done in constant space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// here we reach the mid using the flyods algorithm
// reverse from mid to last

// put 2 ptrs at head of original and reversed linked list and if at any point of time val are different return false
// if both are exhausted return true

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;
        // O(n/2)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // O(n/2)
        ListNode head_ll = helper(slow);
        slow = head;

        // O(n/2)
        while (head_ll != null) {
            if (slow.val != head_ll.val)
                return false;
            slow = slow.next;
            head_ll = head_ll.next;
        }

        return true;

    }

    private ListNode helper(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tempnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempnext;
        }

        return prev;
    }
}
