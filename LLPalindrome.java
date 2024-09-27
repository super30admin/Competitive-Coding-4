// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Break LL in two, reverse second half, compare node by node.
*/
public class LLPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;

        ListNode slow=head, fast=head, prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode head2= reverse(slow);
        if(prev!=null)
            prev.next=null;

        while(head!=null && head2!=null){
            if(head.val!=head2.val) return false;
            head= head.next;
            head2= head2.next;
        }

        if(head!=null) return head.next==null;

        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode curr= head.next, prev= head;

        while(curr!=null){
            prev.next= curr.next;
            curr.next=head;
            head= curr;
            curr= prev.next;
        }

        return head;
    }
}
