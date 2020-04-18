
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//TC:O(N)
//SC:O(1)
class Solution {
    
    
    public ListNode reverse(ListNode l)
    {
       
        
        ListNode current = l;
        ListNode prev = null;
        ListNode next = null;
        
        while(current!=null)
        {
           next=current.next;
           current.next = prev;
           prev= current;
           current=next;
        }
        
        return prev;
        
    }
    
    
    
    
    
    
    public boolean isPalindrome(ListNode head) 
    {
     
      ListNode current = head;
      ListNode slow = head;
      ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
          slow=slow.next;
          fast=fast.next.next; 
        }
        
        if(fast!=null)
            slow=slow.next;
        
        
        ListNode p = reverse(slow);
        
        
        while(p!=null)
        {
           if(p.val!=head.val) 
               return false;
            
          p=p.next;
          head=head.next;
            
        }
        
      return true; 
        
    }
}

