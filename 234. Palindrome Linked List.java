// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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

     public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;

    }

    public boolean isPalindrome(ListNode head) {
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        if(head == null || head.next == null) return true;

        while(fast.next != null && fast.next.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next != null){
            prev = slow;
            slow = slow.next;
        }

        prev.next = null;

        ListNode reversed = reverseList(slow);

        while(head != null && reversed != null){
            if(head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }

        return true;

    }
}
