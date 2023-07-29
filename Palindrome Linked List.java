// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will keep two pointers slow and fast to find out the mid of the linked list. We will move the slow pointer by x speed and fast by 2x. 
//When fast pointer reached the null pointer, slow will be at mid. We will take the value after slow as head and reverse the remaining list and compare it with the first half. If they are same, then we return true, or else false.
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null ||head.next==null) return true;

        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next !=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode head2=slow.next;
        slow.next=null;
        head2=reverse(head2);

        while(head!=null && head2!=null)
        {
            if(head.val!=head2.val) return false;
            head=head.next;
            head2=head2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head2)
    {
        ListNode prev=null;
        ListNode curr=head2;
        ListNode temp=head2.next;

        while(temp!=null)
        {
            curr.next=prev;
            prev=curr;
            curr=temp;
            temp=temp.next;
        }
        curr.next=prev;
        return curr;

    }
   
}