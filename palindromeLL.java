// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Take 2 pointers to find the midpoint
        ListNode slow=head, fast=head.next;

        while(fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        // Reverse the second half of the list, here we don't use additional space
        fast = reverseLL(slow.next);
        slow.next = null;       // mark slow.next to null so that we break the link between the two LLs
        slow=head;              // move slow back to head

        while(fast != null) {   // fast will always be less than or equal to slow, hence checking fast pointer for null
            if (slow.val != fast.val) {     // if there is a difference in value return false
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    // Method to reverse the LL
    private ListNode reverseLL(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }

        ListNode prev=null, curr=head, fast=head.next;

        while (fast != null) {
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
}