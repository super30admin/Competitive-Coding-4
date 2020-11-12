//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

class Palindrome_LinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        // Find mid
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        
        ListNode temp = null;
        ListNode prev = null;
        // Resverse 2nd half of the list
        while(fast != null)
        {
            temp = fast.next;
            fast.next = prev;
            prev = fast;
            fast = temp;
        }
        fast = prev;
        
        while(slow != null && fast != null)
        {
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
