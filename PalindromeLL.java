// TC: O(N) where N represents number of nodes in Linked List
// SC: O(1) since we are using constant space

// We will traverse till the middle of the linked list and we reverse the second half of the list so that we can compare first half and second half and check if they have particular values
// in them.

public class PalindromeLL {

	public boolean Palindrome(ListNode head) {
		
		ListNode slow= head;
		ListNode fast = head;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode prev = null;
		ListNode curr = slow;
		while(curr!=null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		ListNode first = head;
		ListNode second = prev;
		
		while(second!=null) {
			if(first.data!=second.data) {
				return false;
			}
			first = first.next;
			second = second.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		PalindromeLL pl = new PalindromeLL();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		System.out.println(pl.Palindrome(head));
	}
}
