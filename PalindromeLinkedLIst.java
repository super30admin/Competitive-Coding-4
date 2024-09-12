package competitiveCoding4;

// Idea: To put the entire (or second half of) the list in stack, 
// and keep checking the nodes of list from the beginning and popped values from the stack to be equal. 

// Time Complexity: O(2n) because linked list is iterated twice
// Space Complexity: O(n) because of stack with number of nodes of linked list.
import java.util.*;

public class PalindromeLinkedLIst {

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        
        while (head != null) {
            if (head.val != (int)stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
