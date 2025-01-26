// Approach: Find the middle of the linked list using slow and fast pointers. Both pointers start at the head; the slow pointer moves one
// node at a time, while the fast pointer moves two nodes at a time. When the fast pointer reaches the end, the slow pointer will be at the
// middle of the list. Reverse the list from the middle and compare the first and second halves of the list for equality.
// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/palindrome-linked-list/description/

import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeLL {
    static class ListNode {
        int val;
        ListNode next;

        ListNode (int v) {
            val = v;
            next = null;
        }
    }

    boolean isPalindromeUsingStack(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head, prev = null;
        while (slow != null && fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode head2 = reverseLL(slow);
        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    ListNode reverseLL(ListNode head) {
        ListNode prev = null, curr = head, nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalindromeLL pll = new PalindromeLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println("Given linked list is a palindrome (true/false): " + pll.isPalindrome(head));
    }
}