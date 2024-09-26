// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Find mid and reverse the list from the mid. Now compare each node
 * from the 1st half and reversed list.
 *
 */
class Solution {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		if (head.next == null)
			return true;
		ListNode mid = findMid(head);
		ListNode rev = reverse(mid);
		ListNode temp = head;
		while (temp != null && rev != null) {
			if (temp.val != rev.val)
				return false;
			temp = temp.next;
			rev = rev.next;
		}
		return true;
	}

	public ListNode findMid(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse(ListNode head) {
		ListNode prev = null, curr = head;

		while (curr != null) {
			ListNode node = curr.next;
			curr.next = prev;
			prev = curr;
			curr = node;
		}
		return prev;
	}
}