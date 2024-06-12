// Time Complexity : O(n)  n=no of elements in linked list.
// Space Complexity :O(1)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


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
        ListNode s=head;
        ListNode f=head;
        while(f.next!=null && f.next.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        ListNode curr=s.next;
        s.next=null;
        ListNode prev=null;
        //ListNode next=curr.next;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;    
        }
        while(prev!=null)
        {
            if(head.val!=prev.val)
            {
                return false;
            }
            head=head.next;
            prev=prev.next;
        }
        return true;
    }
}
        