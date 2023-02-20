// Time Complexity : O(n) where n in number of nodes in linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We find the mid of list using 2 pointers slo and fast. Then we reverse the 2nd half of list. After that we
   iterate on 2 halves of lists. If value is not equal we return false. Else we return true.
*/

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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode slo = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slo = slo.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slo.next);
        slo.next = null;

        while(head != null && head2 != null) {
            if(head.val != head2.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}