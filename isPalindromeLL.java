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
    public boolean isPalindrome(ListNode head) {
        //base case
        if(head ==null) return true;
        
        ListNode fast=head;
        ListNode slow=head;
        ListNode compareNode =head;
        
        //find mid
        while(fast.next!=null && fast.next.next != null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //reverse
        ListNode reverse=reverse(slow.next);
        
        //compare
        while(reverse!= null){
            if(reverse.val!=compareNode.val) return false;
            reverse=reverse.next;
            compareNode=compareNode.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=null;
        while(head!=null){
            curr=head.next;
            head.next=prev;
            prev=head;
            head=curr;
        }
        return prev;
    }
}