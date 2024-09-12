//time complexity:O(n)
//space complexity:O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        //find the middle element
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        //detach the other half
        ListNode head2=slow.next;
        slow.next=null;
        ListNode prev=null;
        ListNode curr=head2;
        ListNode next;
        //reverse the other linked list
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev = curr;
            curr=next;
        }
        head2=prev;
        //compare the two linked lists
        while(head2 !=null && head!=null)
        {
            if(head2.val!=head.val) return false;
            else{
                head=head.next;
                head2=head2.next;
            }
        }
        return true;
    }
}
