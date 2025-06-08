// TC: O(n)
// SC: O(1)
// Approach: Find mid of list using 2 pointers slow and fast
// Reverse the second half of the list using 3 pointer technique
// Compare both the lists starting from head 
// if value is not same return false else return true

public class PalindromeLinkedList {

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
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode prev = null;
    ListNode curr = slow;

    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }

    ListNode head2 = prev;

    while (head != null && head2 != null) {
      if (head.val != head2.val) {
        return false;
      }
      head = head.next;
      head2 = head2.next;
    }
    return true;
  }
}