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
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
//1.find mid
//2.reverse 2nd half
//3. compare first and second half till second half pointer is not null because the way we are dividing second is always less than or equal to first half.
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        // find mid
        ListNode fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //find reverse of second half
        ListNode p2=rev(slow.next);
        //making end of first half null
        slow.next=null;
        //comparing first and second halves
        ListNode p1=head;
        while(p2!=null){
            if(p1.val!=p2.val) return false;
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }
    private ListNode rev(ListNode head){
        ListNode curr=head,fast=head.next,prev=null;
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}