// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I reverse the second half of the linked list and check if values of each corresponding node of the first and second half are equal.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public bool IsPalindrome(ListNode head) {
        
        // Only one node in linked list
        if(head.next == null)
        {
            return true;
        }

        ListNode slow = head, fast = head.next;

        while(fast!= null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        newHead = Reverse(newHead);

        while(newHead != null)
        {
            if(newHead.val != head.val)
            {
                return false;
            }

            newHead = newHead.next;
            head = head.next;
        }

        return true;

    }

    private ListNode Reverse(ListNode temp)
    {
        ListNode slow = null, medium = null, fast = temp;

        while(fast!=null)
        {
            slow = medium;
            medium = fast;
            fast = fast.next;
            medium.next = slow;
        }

        return medium;
    }
}