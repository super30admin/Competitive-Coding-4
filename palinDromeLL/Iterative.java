package palinDromeLL;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Find mid of the linked list
Reverse the second half of the list
Check if the two sublists match
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Iterative {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd LL
        // if(fast != null) {
        // skip a node
        //     slow = slow.next;
        // }

        // reverse LL
        ListNode headB = reverse(slow);
        ListNode headA = head;

        while(headA != null && headB != null) {

            if(headA.val != headB.val) {
                return false;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}