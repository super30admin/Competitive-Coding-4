package LinkedLists;
/**
 * Time:O(n)
 * Space: O(1)
 * Leetcode accepted: yes
 * Problems faced: Initially got confused between comparison of nodes and node values
 */
public class IsPalindrome {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
//		head.next.next = new ListNode(0);
//		head.next.next.next = new ListNode(1);
		System.out.println(checkPalindrome(head));
	}

	private static boolean checkPalindrome(ListNode head) {
		//No node or single node
		if(head == null || head.next == null) return true;
	
		ListNode slow = head;
		ListNode fast = head.next;
		//Find middle node
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		
		//Reverse the second part of the linked list
		ListNode prev = slow, next;
		while(head2 != null && head2 != slow) {
			next = head2.next;
			head2.next = prev;
			prev = head2;
			head2 = next;
		}
		head2 = prev;
	
//		Traverse through both the lists
		while((!head2.next.equals(head.next)) && (head!= slow && head2 != slow)) {
            if(head.val != head2.val) {
            		return false;
            }
            head = head.next;
			head2 = head2.next;
		}
		return (head.val == head2.val);
	}

}
