// TC: O(n)
// SC: O(1)

// Approach: Find mid, reverse 2nd half of the linked list.
// Then we iterate over first and second half and keep checking if
// the values are equal.

// 234. Palindrome Linked List

class Solution {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }

    ListNode firstHalfEnd = findHalf(head);
    ListNode secondHalfStart = reverse(firstHalfEnd.next);

    ListNode p1 = head, p2 = secondHalfStart;
    while (p2 != null) {
      if (p1.val != p2.val) {
        return false;
      }
      p1 = p1.next;
      p2 = p2.next;
    }

    return true;
  }

  public ListNode findHalf(ListNode head) {
    ListNode fast = head, slow = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public ListNode reverse(ListNode head) {
    ListNode curr = head, prev = null;

    // reversing the second half
    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;

      prev = curr;
      curr = temp;
    }

    return prev;
  }
}