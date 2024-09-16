//Time complexity: O(n)
//Space complexity : O(1
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode l2=reverse(slow.next);
        //fast=l2;
        //slow.next=null;
        ListNode l1=head;
        return check(l1,l2);
        //slow.next=reverse(fast);
        //return true;
    }
    private boolean check(ListNode l1,ListNode l2){
         while(l2!=null){
            if(l1.val!=l2.val){
                return false;
            }
            l1=l1.next;
            l2=l2.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}