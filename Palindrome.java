// time complexity: O(n)
// space Complexity:O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode SH=reverse(slow.next);
        ListNode copy= SH;
        slow=head;
        while(SH!=null){
            if(slow.val!=SH.val){
                return false;
            }
            slow=slow.next;
            SH=SH.next;
        }
        reverse(copy);
        return true;
        
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}