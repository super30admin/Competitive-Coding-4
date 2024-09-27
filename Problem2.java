// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
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
       if(head==null || head.next==null)
            return true;
        
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!= null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        if (fast!=null)
            slow=slow.next;
        
        slow=reversell(slow);
        while(slow!=null)
        {
            if(slow.val!=head.val)
                return false;
            slow=slow.next;
            head=head.next;
            
        }
        return true;
    }
    public ListNode reversell(ListNode head)
    {
        ListNode prev=null;
        while(head!=null)
        {
            ListNode temp= head.next;
            head.next=prev;
            prev=head;
            head=temp;          
            
        }
        return prev;
    }
}