// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: split the list from middle and reverse the second half list and then compare it with 1st half list.

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode temp=head;
        ListNode mid= midList(head);
        ListNode newHead= reversed(mid.next);
    
        while(newHead!=null){
            if(temp.val!=newHead.val){
                return false;
            }
            temp=temp.next;
            newHead=newHead.next;
        }
        return true;
    }

    private ListNode midList(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private ListNode reversed(ListNode head){
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
            ListNode front= temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;

        }
        return prev;
    }
}