/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * 
 */
public class PalindromeLinkedList {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return true;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null && slow.next != null) {
			slow = slow.next;

		}

		slow = reverse(slow);
		fast = head;

		while (slow != null) {

			if (fast.val != slow.val)
				return false;

			slow = slow.next;
			fast = fast.next;
		}

		return true;

	}

	private ListNode reverse(ListNode head) {

		ListNode pre = null;
		ListNode fast = head.next;
		ListNode curr = head;

		while (fast != null) {
			curr.next = pre;
			pre = curr;
			curr = fast;
			fast = fast.next;

		}

		curr.next = pre;

		return curr;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PalindromeLinkedList objIn = new PalindromeLinkedList();

	}

}
