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
 // Time Complexity - O(n)
 // Space - O(1)
 // Faced any issues while solving - No
 // Solved on leetcode- yes
 // I am dividing the problem into 3 parts. (a) Finding the middle (b) Reversing the 2nd half (c) Comparing values in 2 lists
 // Finding middle can be using slow and fast pointers, then reversing using a prev variable to store the address and then comparing the values returning false immediately when values doesn't match
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        if(head.next == null) return true;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);
        slow.next = null;
        slow = head;

        while(newHead!=null) {
            if(slow.val != newHead.val) {
                return false;
            } 
            slow = slow.next;
            newHead = newHead.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        if(head.next == null) return head;
        while(head!=null) {
            ListNode t = head.next;
            head.next = prev;
            prev = head;
            head = t;
        }
        return prev;
    }
}
