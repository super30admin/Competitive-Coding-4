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
    // TC -> O(N) , 3 times we are traversing
    // SC -> O(1) , No extra space used
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        // 1 -> 2 -> 3 -> 2 -> 1 -> null odd no of nodes
        // 1 -> 2 -> 3 -> 3 -> 2 -> 1 -> null even no of nodes

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Mid is at slow pointer
        fast = slow.next;
        slow.next = null;

        // Reverse second list that starts from fast using 3 Pointers
        ListNode prev = null;
        ListNode curr = fast;
        ListNode next = fast.next;
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;

        // Now we have both lists, which should be identical if they are Palindrome
        ListNode p1 = head;
        ListNode p2 = curr;

        // Length of p1 an p2 can be equal or p1 can be greater than p2 by 1.
        while(p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
