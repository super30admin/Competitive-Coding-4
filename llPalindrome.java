// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.


// Your code here along with comments explaining your approach


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public boolean isPalindrome(ListNode head) {
		 ListNode slow = head;
		 ListNode fast = head.next;
		 
		 while(fast != null && fast.next!=null) {
			  slow = slow.next;
			  fast = fast.next.next;
		 }
		 ListNode rev = reverse(slow.next);
		 
		 fast = head;
		 
		 boolean isValid = true;
		 while(rev != null) {
			  if (rev.val != fast.val) {
					isValid = false;
			  }
			  fast = fast.next;
			  rev = rev.next;
		 }
		 
		 return isValid;
	}
	
	private ListNode reverse(ListNode head) {
		 ListNode slow = head;
		 ListNode prev = null;
		 
		 while(slow != null) {
			  ListNode temp = slow.next;
			  slow.next = prev;
			  
			  prev = slow;
			  slow = temp;
		 }
		 
		 return prev;
	}
}