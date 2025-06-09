// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//    Used Deque (double-ended queue) to check if a linked list is a palindrome by comparing the front and back values to check for symmetry — a valid palindrome check.


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
class PalindromeLinkedList_LC234 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        if (head == null) return true;
        else deque.addLast(head.val);

        ListNode temp = head.next;
        while (temp != null) {
            deque.addLast(temp.val);
            temp = temp.next;
        }

        while (deque.size() != 0 && deque.size() != 1 && !deque.isEmpty()) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}