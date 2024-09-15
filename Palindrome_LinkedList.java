// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class ListNode {
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

class Palindrome_LinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode slow1 = reverse(slow.next);
		fast = head;
		while (slow1 != null) {
			if (slow1.val != fast.val) {
				return false;
			}
			slow1 = slow1.next;
			fast = fast.next;
		}
		return true;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}