// 234. Palindrome Linked List - https://leetcode.com/problems/palindrome-linked-list/
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, Cycles in reversed list

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
        // base case
        if(head == null || head.next == null) return true;
        
        // find mid
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next !=null){ //1,2
            slow=slow.next;
            fast=fast.next.next;
        }
        
        // reverse
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        System.out.print(fast.val+ " " + slow.val);
        // compare
        while(fast!=null){
            if(slow.val == fast.val){
                slow=slow.next;
                fast=fast.next;
            }
            else{
            return false;
            }
        }
        return true;
    }
    
    private ListNode reverse(ListNode rhead){
        ListNode prev = null; // 2,1
        ListNode next1 = rhead.next; // 1
        while(next1!=null){
            rhead.next=prev; // null
            prev=rhead; // 2
            rhead=next1; // 1
            next1=next1.next; // null
        }
        rhead.next = prev; // null - This was the issue = This was forming cycles
        
        return rhead;
    }  
}