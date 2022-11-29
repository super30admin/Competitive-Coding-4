// Time Complexity : O(n)
// Space Complexity :O(1) 
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow=head, fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        fast=slow.next;
        slow.next=null;
        fast=reverse(fast);
        
        slow=head;
        while(slow!=null && fast!=null){
            if(slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode fast=head.next;
        while(fast!=null){
            head.next=prev;
            prev=head;
            head=fast;
            fast=fast.next;          
        }
        
        head.next=prev;
        return head;
    }
}