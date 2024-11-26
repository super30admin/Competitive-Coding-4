// Time Complexity : O(n). n is the number of nodes in a Linked list
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


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
    ListNode slow;
   
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        slow=head;
        ListNode fast=head,f=head;
        
        boolean isFalse = palind(fast);
         return isFalse;
    }
    
    private boolean palind(ListNode head){
        if(head==null) return true;
        
        if(palind(head.next)==false) return false;
        
        
        else if(slow.val==head.val){
            slow=slow.next;
            //temp++;
            return true;
        }else{
            return false;
        }
    
    }
}
