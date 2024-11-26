// Time Complexity :O(n) n is number of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public boolean isPalindrome(ListNode head) {
       
        if(head == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null ) // find middle
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode next = null;
        while(curr!=null)          // reverse second half
        {   
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
         ListNode head1 = head;
         ListNode head2 = prev;
        while(head2!=null && head1!=null) // compare the two list
        {
            if(head1.val!=head2.val)
                return false;
            head2 = head2.next;
            head1 = head1.next;
            
        }
        
        return true;
        
    }
}