// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Find mid of the linked list
Reverse the second half of the list
Check if the two sublists match
 */

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
        if(head==null)
            return true;

        ListNode mid=findMid(head);
        ListNode secondStart=reverse(mid.next);

        boolean flag=true;
        ListNode firstStart=head;
        while(secondStart!=null){
            if(firstStart.val!=secondStart.val){
                flag=false;
                break;
            }
            firstStart=firstStart.next;
            secondStart=secondStart.next;
        }

        return flag;
    }

    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }

    public ListNode findMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
