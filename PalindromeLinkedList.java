// Time Complexity : O(n) n is number of nodes
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)   return true;
        
        //midpoint of linkedlist
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode curr = slow, prev = null, next = null;
        
        //reverse the linkedlist
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        fast = head;
        
        //check value of node
        while(prev != null){
            if(prev.val != fast.val)    return false;
            prev = prev.next;
            fast = fast.next;
        }
        return true;
    }
}
