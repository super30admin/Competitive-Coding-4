// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here with comments explaining your approach
// -Find the middle element of linked list using Fast and slow pointers(Floyds
// Algorithm)
// -Reverse the list from the middle element to the end
// -Check the first element from both the list and the reversed middle of the
// list
// -if they dont match return false

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode middle = findMiddle(head);
        ListNode start2 = reverseList(middle.next);
        ListNode start1 = head;
        // loop untill end of the list
        while (start2 != null) {
            if (start1.val != start2.val)
                return false;
            start1 = start1.next;
            start2 = start2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        // use temp node to store the next node and change the pointer direction
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private ListNode findMiddle(ListNode head) {
        // find the middle element by moving one pointer at twice the pace of other
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}