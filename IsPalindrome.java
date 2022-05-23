/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class IsPalindrome {
  // Time Complexity : O(n)
  // Space Complexity : O(n)
  // Did this code successfully run on Leetcode : Yes
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }

    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    if (fast != null) {
      slow = slow.next;
    }

    Stack<ListNode> stack = new Stack<ListNode>();
    while (slow != null) {
      stack.add(slow);
      slow = slow.next;
    }

    slow = head;
    while (!stack.isEmpty()) {
      if (slow.val != stack.pop().val) {
        return false;
      }

      slow = slow.next;
    }

    return true;
  }
}