// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){		// find the middle point using slow and fast pointers
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);	// get the head of the second half of the linkedlist which is now reversed
        slow = head;				// repoint the slow to original head	
        
        while(fast != null){
            if(slow.val != fast.val){		// compare fast and slow values, if not equal then return false
                return false;
            }
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head){		// reverse the linkedlist using prev, curr and next point method
        ListNode prev = null;
        ListNode curr = head;
        ListNode NextNode = head.next;
        
        while(curr.next != null){
            curr.next = prev;
            prev = curr;
            curr = NextNode;
            NextNode = curr.next;
        }
        
        curr.next = prev;
        return curr;
    }
}