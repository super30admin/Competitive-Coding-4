public class PalindromeLL {
	public boolean isPalindrome(ListNode head) {
		boolean palin = false;
		if (head == null || head.next == null) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode comp = reverse(slow.next);

		while (comp != null) {
			if (head.val == comp.val) {
				palin = true;
			} else {
				palin = false;
				return palin;
			}
			head = head.next;
			comp = comp.next;
		}

		return palin;

	}

	public ListNode reverse(ListNode slow) {
		ListNode prev = null;
		ListNode curr = slow;

		while (curr != null && slow != null) {
			slow = slow.next;
			curr.next = prev;
			prev = curr;
			curr = slow;

		}

		return prev;

	}
}
