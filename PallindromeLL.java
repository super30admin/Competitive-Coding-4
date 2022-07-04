//https://leetcode.com/problems/palindrome-linked-list/
// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        //find middle
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        //middle is at slow pointer
        ListNode curr=reverse(slow.next);
        slow.next=null; //make first half end to null
        while(curr!=null)
        {
            if(curr.val!=head.val)
                return false;
            curr=curr.next;
            head=head.next;
                
        }
        return true;
        
    }
    private ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        ListNode fast=head.next;
      
        while(fast!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}