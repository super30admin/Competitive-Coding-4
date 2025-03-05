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
        if(head==null) return true;
        ListNode slow= head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null)

        {
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode head2=slow.next;

        slow.next=null;

        ListNode prev=null;
        ListNode cur= head2;
        ListNode next;

        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        head2=prev;

        while(head!=null && head2!=null)
        {
            if(head.val != head2.val) return false;
            else
            {
                head=head.next;
                head2= head2.next;
            }
        }
        return true;

    }
}