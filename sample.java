// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Got confused with the reversing the list part


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
        if(head==null || head.next==null){
            return true;
        }
        int size=0;
        int mid=0;
        ListNode temp = head;
        //find length
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        
        //find mid
        mid=size/2;
        ListNode temp1 = head;
        int index=0;
        //traverse till mid & create first list
        while(index < mid){
            temp1=temp1.next;
            index++;
        }
         ListNode temp2 =null;
         //reverse the second list
        if(size%2!=0){

            temp2=reverse(temp1.next);
        }else{
            temp2=reverse(temp1);
        }
     
        temp1.next=null;
        temp1=head;
        //compare
        while(temp1!=null && temp2!=null){
            if(temp1.val!=temp2.val){
                return false;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode slow){
        ListNode curr =null;
        ListNode fast= slow.next;
        while(fast!=null){
            slow.next=curr;
            curr=slow;
            slow=fast;
            fast=fast.next;
        }
        slow.next= curr; 
        return slow;
    }
}