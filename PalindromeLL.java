// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        slow=reverse(slow);
        fast=head;
        
        while(slow!=null){
            if(fast.val!=slow.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
        
        
    }
    ListNode prev=null;
    private ListNode reverse(ListNode head){
        while(head!=null){
        ListNode temp=head.next;
        head.next=prev;
        prev=head;
        head=temp;
        }
        return prev;
        
    }
}