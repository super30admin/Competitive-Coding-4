/*
This approach solves the problem in three steps. In the first step, we find the midpoint of the linked list by
using a fast and a slow pointer. Then, we reverse the list that is after the midpoint, and seperate it from the
midpoint. We now have two lists, and in the final step we start from the head of both the lists and compare the
values at each position iteratively till the end.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity = O(n)
    //Space Complexity = O(1)
    public boolean isPalindrome(ListNode head) {
        
        if(head == null)
            return false;
        
        if(head.next == null)
            return true;
        
        //Finding the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //slow is now at the midpoint
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        while(fast != null)
        {
            if(head.val != fast.val)
                return false;
            
            head = head.next;
            fast = fast.next;
        }
        
        return true;
            
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast != null)
        {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = curr.next;
        }
        
        curr.next = prev;
        return curr;
    }
}