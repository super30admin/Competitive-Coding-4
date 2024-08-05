//TC: O(n)
//SC: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode node) {
        if(node==null)   return null;
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = node;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)   return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseList(slow);
        if(fast == null)    return false;
        slow = head;
        while(fast != null) {
            if(fast.val != slow.val)    return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}