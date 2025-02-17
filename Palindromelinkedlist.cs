//TimeComplexity - O(n) as we are doing it in place
// spaceComplexity - O(1)
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
// Approach -  Find middle element
//  reverse second half
// compare two lists
// restore original list

public class Solution
{
    public bool IsPalindrome(ListNode head)
    {
        // base condition
        if (head == null || head.next == null)
        {
            return true;
        }
        // use two pointers     
        ListNode slow = head;
        ListNode fast = head;
        // Get middle element
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse second part
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null)
        {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        ListNode head2 = prev;
        // compare two lists
        fast = prev;
        slow = head;
        bool isPal = true;
        while (slow != null && fast != null)
        {
            if (slow.val != fast.val)
            {
                isPal = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }

        // restore original list
        prev = null;
        curr = head2;
        while (curr != null)
        {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return isPal;
    }
}