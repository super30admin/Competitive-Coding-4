// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* First find the middle element by using two pointers.
 * Reverse the second half of the list and check whether the two list has same values or not */

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Palindrome_LinkedList {
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null)
			return true;

		// two pointers to find the middle
		ListNode slow = head;
		ListNode fast = head;

		while(fast.next != null && fast.next.next != null){	// for even and odd lists
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode head2 = slow.next;
		slow.next = null;	// break the link between two lists

		head2 = reverse(head2);	// reversal, reversing from mid next and having new node head2 to it

		while(head2 != null && head != null){
			if(head.val != head2.val)
				return false;

			head2 = head2.next;
			head = head.next;

		}
		return true;
	}

	private ListNode reverse(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		ListNode fast = head.next;

		while(fast != null){
			curr.next = prev;
			prev = curr;
			curr = fast;
			fast = fast.next;
		}
		curr.next = prev;
		return curr;
	}
}
