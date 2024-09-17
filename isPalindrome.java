/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity :  O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;


        while(slow != null){
            if(fast.val != slow.val){
            return false;

            }
            fast = fast.next;
            slow = slow.next;
            // fast = fast.next;

        }
        return true;
    }


    public ListNode reverse(ListNode head){
        ListNode prev = null;
        // ListNode next = head.next;
        while(head != null){
          ListNode next = head.next;
          head.next = prev;
          prev = head;
          head = next;
        }
        return prev;
    }
}