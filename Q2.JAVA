// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    private ListNode reverse(ListNode head){
        //base
        if(head==null || head.next==null){
            return head;
        }
        ListNode lastHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return lastHead;

    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode list1=head;
        ListNode list2=reverse(slow);
        while(list2.next!=null){
            if(list1.val!=list2.val)return false;
            list1=list1.next;
            list2=list2.next;
        }
        return true;
    }
}