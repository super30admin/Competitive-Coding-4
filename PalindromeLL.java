// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Find the middle element of LL using slow and fast pointer.
// 2. Reverse the 2nd half of the linkedlist after finding middle element
// 3. Compare the starting of LL with the 2nd part of linked link until we reach middle of the linked list
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow=head, fast=head;
        // finding middle element
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        // reversing 2nd half of LL
        ListNode mid=reverseList(slow); 
        // comparing first half and 2nd half of reversed LL
        while(mid!=null){
            if(head.val!=mid.val) return false;
            head=head.next;
            mid=mid.next;
        }
        return true;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode temp=null;
        ListNode curr=head;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}