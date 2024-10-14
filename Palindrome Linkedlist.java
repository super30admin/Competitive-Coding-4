// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/** * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // aesha
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;

        ListNode prev = head;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            // System.out.println(prev.val);
        }

        ListNode list = prev;
        System.out.print(prev);
        while (list != null && head != null) {
            if (list.val != head.val) {
                return false;

            }
            list = list.next;
            head = head.next;
        }

        return true;

    }
}