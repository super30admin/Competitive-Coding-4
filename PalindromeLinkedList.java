/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Time COmplexity: O(n)
// Space Complexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        ListNode root = head;

        while(slow != null) {
            if(slow.val != root.val) {
                return false;
            }
            slow = slow.next;
            root = root.next;
        }

        return true;
    }

    private ListNode reverse(ListNode root) {
        ListNode prev = null;
        while(root != null) {
            ListNode temp = root.next;
            root.next = prev;
            prev = root;
            root = temp;
        }
        return prev;
    }
}