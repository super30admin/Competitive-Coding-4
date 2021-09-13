// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

1. find the middle
2.reverse the second half of the list
3. compare first half with the second half

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
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        
        ListNode secondHalfStart = findmiddle(head);
        
        ListNode fisrt = head;
        
        ListNode second = reverse(secondHalfStart);
        
        while(fisrt != null && second != null)
        {
            if(fisrt.val != second.val)
                return false;
            
            fisrt = fisrt.next;
            second = second.next;
        }
    
        return true;
    }
    
    private ListNode findmiddle(ListNode head)
    {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while(fast!= null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        return slow.next;
    }
    
    private ListNode reverse(ListNode startOfSecondHalf)
    {
        ListNode prev = null;
        ListNode curr = startOfSecondHalf;
       
        while(curr != null )
        {
            ListNode nextemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextemp;
            
        }
        
        return prev;
    }
}