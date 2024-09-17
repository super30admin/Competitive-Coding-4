//time complexity :O(N)
//Space complexity :O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        //base case
        boolean result = true;
        if(head == null)
            return true;
        //finding the mid point
        ListNode Slow = head ,fast = head;
        while(fast!=null && fast.next!=null)
        {
            Slow =Slow.next;
            fast=fast.next.next;
        }
        ListNode mid = Slow;
        ListNode prev = null;
        ListNode current = mid;
        ListNode temp = mid.next;
        
        //reverse the second half of the list
        while(temp!=null)
        {
           current.next = prev;
            prev = current;
            current = temp;
            temp = temp.next;

        }
        current.next = prev;
        
        //compare list
        ListNode head1 = head;
        ListNode head2 = current;
        
        while(head1!=null && head2!=null)
        {
            if(head1.val!=head2.val)
            {
                result = false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
            
            
      return result;      
            
    }
}