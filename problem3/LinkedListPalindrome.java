//Time Complexity : O(n), n -> Number of nodes in the list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

package problem3;

public class LinkedListPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}

		ListNode fastPtr = head;
		ListNode slowPtr = head;

		while (fastPtr.next != null && fastPtr.next.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}

		ListNode reversedListHead = reverseList(slowPtr.next);

		ListNode node = head;

		while (node != null && reversedListHead != null) {
			if (node.val != reversedListHead.val) {
				return false;
			}

			node = node.next;
			reversedListHead = reversedListHead.next;
		}
		return true;
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static void main(String[] args) {
		LinkedListPalindrome obj = new LinkedListPalindrome();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);

		System.out.println("Is the given linked list a palindrome? " + (obj.isPalindrome(head) ? "Yes" : "No"));
	}

}
