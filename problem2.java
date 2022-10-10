package Competitive-Coding-4;
//Q 234:- Leetcode
public class problem2 {
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public boolean isPalindrome(ListNode head) {
        
    if(head == null || head.next == null){
        return true;
    }
    
    // find mid and break linkedlist in two part from mid
    ListNode slow = head;
    ListNode fast = head;
    while(fast!=null && fast.next!=null && fast.next.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    
    // reverse the second part of linked list
    ListNode curr = slow.next;
    ListNode prev = null;
    while(curr != null){
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
    }
    
    fast = prev; // head of second part
    slow = head; // head of first part
    while(slow != null && fast != null){
        if (slow.val != fast.val){
            return false;
        }
        slow = slow.next;
        fast = fast.next;
    }
    
    return true;
}
}
