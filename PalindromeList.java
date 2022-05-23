/**

Time Complexity : O(N)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class Solution 
{
    public boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // slow is at mid point
        
        ListNode reversedListHead = reverse(slow); // head of second half reversed

        ListNode temp1 = head;
        ListNode temp2 = reversedListHead;
        while(temp2 != null && temp1 !=null)
        {
            if(temp1.val != temp2.val)
                return false;
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        
        while(head !=null)
        {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            
            head = temp;
        }
        
        return prev;
    }
}