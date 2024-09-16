// Time Complexity : O(N)
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Find mid point of the list.
 * 2. Reverse second half of the list.
 * 3. compare first and second reverse list.
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode slowp = head;
		ListNode fastp = head;
		
		//find mid
		while (fastp.next != null && fastp.next.next != null) {
			slowp = slowp.next;
			fastp = fastp.next.next;
		}

		slowp = slowp.next;
		
		//rever second half of the list
		ListNode prev = null;
		while (slowp != null) {
			ListNode temp = slowp.next;
			slowp.next = prev;
			prev = slowp;
			slowp = temp;
		}
		
		//compare first and second half of the list
		while (prev != null) {
			if(prev.val!=head.val)
			{
				return false;
			}
			prev = prev.next;
			head = head.next;
		}
		return true;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next= new ListNode(1);
		System.out.println(new PalindromeLinkedList().isPalindrome(head));
	}
}
