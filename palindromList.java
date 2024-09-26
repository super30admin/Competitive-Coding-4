// Time Complexity :O(n) n-nodes in the list
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes 
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if(head==null || head.next==null) return true;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow.next);
        slow.next=null;
        slow=head;
        while(fast!=null)
        {
            if(slow.val!=fast.val)
            {
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
        
    }
    private ListNode reverse(ListNode head)
    {
        ListNode temp=null;
        ListNode prev=head;
        while(head!=null)
        {
            prev=head;
            head=head.next;
            prev.next=temp;
            temp=prev;
        }
        return prev;
    }
}