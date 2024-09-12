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
//Time complexity: O(n)
//Space complexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
      
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast.next!=null && fast.next.next!=null )
        {
            slow=slow.next;
            fast=fast.next.next;
            prev=slow;
        }
        boolean res=true;
        if(fast.next!=null)
        {
           
           ListNode prev1=null;
            ListNode curr= slow.next;
            ListNode temp=null;
            while(curr!=null)
            {
                temp=curr.next;
                curr.next=prev1;
                prev1=curr;
                curr=temp;
                
                
            }
            slow.next=null;
            slow=head;
            fast=prev1;
            while(slow!=null && fast!=null)
            {
                System.out.println(slow.val+" "+fast.val);
                if(fast.val==slow.val)
                    
                {
                    slow=slow.next;
                fast=fast.next;
                }
                else
                {
                    res=false;
                    System.out.println(res);
                    break;
                }
                
            }
        }
       else if(fast.next==null)
        {
           ListNode prev1=null;
            ListNode curr= slow.next;
            ListNode temp=null;
            while(curr!=null)
            {
                temp=curr.next;
                curr.next=prev1;
                prev1=curr;
                curr=temp;
                
                
            }
            slow.next=null;
            prev.next=null;
            slow=head;
            fast=prev1;
            while(slow!=null && fast!=null)
            {
                if(fast.val==slow.val)
                    {
                    slow=slow.next;
                fast=fast.next;
                }
                else
                {
                    res=false;
                    System.out.println(res);
                    break;
                }
                 
            }
        }
        return res;
    }
}