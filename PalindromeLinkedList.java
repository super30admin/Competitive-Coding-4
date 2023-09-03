// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
   
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next==null) return true;
        ListNode firstHalfEnd = firstHalfList(head); //o(n)
        
        ListNode secondHalf = reverse(firstHalfEnd.next);//o(n)
        ListNode check = secondHalf;

        
        ListNode start = head;
        ListNode end = secondHalf;
        boolean result = true;
        while (result && end != null) { //o(n)
            if (start.val != end.val) result = false;
            start = start.next;
            end = end.next;
        }
        return result;
    }
    private ListNode firstHalfList(ListNode curr){
        ListNode slow=curr;
        ListNode fast=curr;
        
        while(fast.next!=null && fast.next.next!=null){
           
            slow=slow.next;
            fast=fast.next.next;
            
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        System.out.println(head.val);
        ListNode prev=null;
        ListNode curr=head;
        ListNode fast=head.next;
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