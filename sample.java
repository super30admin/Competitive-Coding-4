LinkedList Palindrome:


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : np


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
        if(head==null) return true;
        ListNode temp = head.next;
        ListNode middle = head;
        while(temp!=null && temp.next!=null){
            middle=middle.next;
            temp=temp.next.next;
        }
        ListNode head2=middle.next;
        
        middle.next=null;
        /*while(head!=null ){
            System.out.println(head.val);
            head=head.next;
        }
         while(head2!=null){
            System.out.println(head2.val);
            head2=head2.next;
        }*/
        ListNode prev=null;
        ListNode curr=head2;
        ListNode fast;   //=head2.next;
        
        while(curr!=null){
            fast=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fast;
            //fast=fast.next;
        }
        head2=prev;
        
        while(head!=null && head2!=null){
            if(head.val!=head2.val){
                return false;
            }
            head=head.next;
            head2=head2.next;
        }
        return true;

            
    }
}