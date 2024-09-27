/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        if(head.next.next==null&&head.val!=head.next.val) return false;
        if(head.next.next==null&&head.val==head.next.val) return true;
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null,curr=slow,next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode l1=head,l2=prev;
        while(l1!=null&&l2!=null){
            if(l1.val!=l2.val) return false;
            l1=l1.next;
            l2=l2.next;
        }
        return true;
    }
}