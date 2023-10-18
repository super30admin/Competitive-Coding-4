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
    public boolean isPalindrome(ListNode head) {
         if (head == null || head.next == null) {
            return true; 
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverseLL(slow.next);
        slow.next = null;
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false; 
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;   
    }

     ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
