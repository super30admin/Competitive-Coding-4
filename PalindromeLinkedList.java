package competitveCoding4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	//Iterative
	//Time Complexity : O(n), traversing the list and array
	//Space Complexity : O(n), for stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        
        while(!stack.isEmpty()) {
            if(head.val != stack.pop().val)
                return false;
            head = head.next;
        }
        
        return true;
    }
	
	//Recursive
	//Time Complexity : O(n), traversing the list
	//Space Complexity : O(n), for inner stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	ListNode first;
    boolean flag;
    public boolean isPalindrome1(ListNode head) {
        first = head;
        flag = true;
        helper(head);
        return flag;
    }
    
    private void helper(ListNode head) {
        if(head == null)
            return;
        
        helper(head.next);
        if(head.val != first.val) {
            flag = false;
            return;
        }
        first = first.next;
    }
	 
	//Brute Force
	//Time Complexity : O(n), traversing the list and array
	//Space Complexity : O(n), for List
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int left = 0, right = list.size() - 1;
        
        while(left < right) {
            if(list.get(left) != list.get(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}
