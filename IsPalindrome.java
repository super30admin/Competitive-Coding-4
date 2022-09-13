/**
https://leetcode.com/problems/palindrome-linked-list/
 
Time Complexity :   O (N) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (234. Palindrome Linked List)
Any problem you faced while coding this :       No
 */

// Input: head = [1,2,2,1]

class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if( head == null || head.next == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Finding mid
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the list from mid to end
        ListNode prev = null;
        ListNode curr = slow.next;
        fast = curr.next;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        
        // curr: head of reverse
        slow = head;
        fast = curr;
        
        // increment slow and fast and compare values
        while(fast != null && slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next; 
        }
        return true;
    }
}