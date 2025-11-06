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
        if (head == null || head.next == null) return true;
        ListNode dummy = new ListNode{
        val = 0,
        next = head,
        };
        ListNode slowPtr = dummy;
        ListNode fastPtr = dummy;
        while(fastPtr != null && fastPtr.next != null)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        ListNode head1 = slowPtr.next;
        slowPtr.next = null;
        ListNode prev = null;
        ListNode current = head1;
        ListNode temp = current.next;

        while(temp!= null)
        {
            current.next = prev;
            prev= current;
            current = temp;
            temp = temp.next;
        }
        current.next = prev;
        ListNode reverseHead = current;
        while(reverseHead!=null)
        {
            if(head.val!=reverseHead.val)
            {
                break;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        if(reverseHead!=null) return false;
        if(head == null || head.next == null) return true;

        return false;

        
    }
}