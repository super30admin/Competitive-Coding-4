  
// Time Complexity : O(N)
// Space Complexity : O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        ListNode slow=head, fast=head;
        while(fast.next != null && fast.next.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        fast=reverse(slow.next);
        slow=head;
        
        while(fast != null)
        {
            if(slow.val != fast.val)
                return false;
            
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
    private ListNode reverse(ListNode node)
    {
        ListNode rev=null, cur=node, next;
        while(cur != null)
        {
            next=cur.next;
            cur.next=rev;
            rev=cur;
            cur=next;
        }
        return rev;
    }
}
