//Time Complexity: O(n)
// Space Complexity: O(1)
// Leetcode: 234. Palindrome Linked List - Easy
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode slow=head;
        ListNode fast=head;
        // Initially before entering the loop , my 'fast' is not null. Since fast is moving 2 steps, I will have to check
        //fast.next and fast.next.next are not null
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode shead=slow.next;
        slow.next=null;
        shead=reverse(shead);
        while(head!=null && shead!=null)
        {
            if(head.val!=shead.val)
                return false;
            head=head.next;
            shead=shead.next;
        }
        return true;
    }
    public ListNode reverse(ListNode shead)
    {
        ListNode prev=null;
        ListNode curr=shead;
        ListNode next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}