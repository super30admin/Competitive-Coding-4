// Time Complexity : O(number of nodes of linked list)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
    ListNode tmp;
    public boolean helper(ListNode head) {
        if(head==null)
            return true;
        if(!helper(head.next))
            return false;
        int tmpVal = tmp.val;
        tmp=tmp.next;
        return tmpVal==head.val;

        }
    
    public boolean isPalindrome(ListNode head) {
        tmp=head;
        return helper(head);
    }
    
    
}