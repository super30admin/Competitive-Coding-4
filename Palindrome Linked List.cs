/*
  Time complexity:O(n)
  Space complexity:O(1)

  Code ran successfully on Leetcode: Yes

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public bool IsPalindrome(ListNode head) {
        
        if(head==null)
            return true;
    
        ListNode firstHalfEnd = getFirstHalfEnd(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        
        
        ListNode p1= head;
        ListNode p2 = secondHalfStart;
        
        bool result = true;
        
        while(result && p2!=null)
        {
            if(p1.val!=p2.val)
                result = false;
            
            p1=p1.next;
            p2=p2.next;
        }
        
        firstHalfEnd.next = reverseList(secondHalfStart);
            
        return result;
    }
    
    private ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null)
        {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev=curr;
            curr=nextTemp;
        }
        
        return prev;
    }
    
    private ListNode getFirstHalfEnd(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
}
