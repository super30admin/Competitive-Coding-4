class Solution {
    public boolean isPalindrome(ListNode head) {
       ListNode slow=head;
    ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next=null;
        
        ListNode prev =null;
        ListNode curr=head2;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        } 
        head2=prev;
        while(head!=null && head2!=null){
            if(head.val!=head2.val){
                return false;
            }else{
                head=head.next;
                head2=head2.next;
            }
        }
        return true;
    }
}
