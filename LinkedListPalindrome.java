// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }
        // finding the end of first half using two pointers - slow and fast
        ListNode endOfFirstHalf = endOfFirstHalf(head);
        // reverse the second half
        ListNode startOfSecondHalf = reverseList(endOfFirstHalf.next);

        ListNode p= head;
        ListNode q = startOfSecondHalf;
        boolean result = true;
        // comparing the val of first half and second half to check if it palindrome or not
        while(result && q != null){
            if(p.val != q.val) {
                return false;
            }
            p = p.next;
            q= q.next;
        }

        endOfFirstHalf.next = reverseList(startOfSecondHalf);
        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;

    }
}