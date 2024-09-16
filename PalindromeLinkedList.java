/* Time Complexity :  O(n)
   Space Complexity :  O(1) 
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
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
        ListNode slow=head;
        ListNode fast= head;
        //find mid
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //reverse the second half
        ListNode dummy=null, cur=slow;
        if(cur==null) fast=null;
        else
        fast=cur.next;
        while(fast!=null){
            cur.next=dummy;
            dummy=cur;
            cur=fast;
            fast=fast.next;
        }
        cur.next=dummy;
        //check palindrome
        while(head!=null && cur!=null)
        {
            if(head.val==cur.val){
                head=head.next;
                cur=cur.next;
            }
            else
            {
                return false;
            }
        }
        return true;
        
    }
}