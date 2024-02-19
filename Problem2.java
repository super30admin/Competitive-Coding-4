// https://leetcode.com/problems/palindrome-linked-list/description/

// Time Complexity : O(N), N is number of nodes 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    private ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }

        ListNode prev=null;
        ListNode curr=head;
        ListNode fast;

        while(curr!=null){
            fast=curr.next;

            curr.next=prev;

            prev=curr;
            curr=fast;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }

        // Find middle of the list
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // Reverse second half
        fast=slow.next;
        slow.next=null;
        fast = reverseList(fast);

        // Compare the two halves
        slow=head;
        while(slow!=null && fast!=null && slow.val==fast.val){
            slow=slow.next;
            fast=fast.next;
        }

        if(fast==null){
            return true;
        }
        return false;
    }
}