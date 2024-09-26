// Time Complexity :O(n) n:number of elements
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//reach mid point of linked list and then reverse rest of the half. Compare two halves and return true if every element is same

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
        if(head==null) {
            return true;
        }
        ListNode FirstHalfpoint=firsthalf(head);
        ListNode SecondHalftpoint=reverseList(FirstHalfpoint.next);
        FirstHalfpoint=head;
        while(SecondHalftpoint!=null){
           if(FirstHalfpoint.val!=SecondHalftpoint.val){
                return false;
            }else{
                FirstHalfpoint=FirstHalfpoint.next;
                SecondHalftpoint=SecondHalftpoint.next;
            }
        }
        return true; 
    }
    private ListNode firsthalf(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next; 
        }
      return slow;  
    }
    private ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    } 
}
