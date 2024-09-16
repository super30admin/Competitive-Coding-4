// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    Go to the middle element, reverse the second half of the linked list, compare both the linked lists
*/

class Solution 
{
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null || head.next==null) return true;
        ListNode slow = head, fast = head ;
        ListNode p=null,q=null,temp=null;
        int count=0;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            
            q=slow.next;
            slow.next=p;
            p=slow;
            slow=q;
            if(fast==null) break;
            else if(fast.next==null) q=q.next;
        }
        
        while(p!=null && q!=null)
        {
            if(p.val==q.val)
            {
                p=p.next;
                q=q.next;
            }
            else return false;
        }
        return true;
     }
}