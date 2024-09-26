
public class Palindrome_Linked_List {
	//Approach:
	//1. For checking if a linked list is palindrome, I have found the middle of the list with slow and fast pointer. 
	//2. Then I have reversed the list after the middle part. Now if its a even palindrome, we can check the nodes starting from actual head and reversed head for similarity.
	//3. To handle odd palindromes, we just have to iterate when smaller list reaches null.  
	 public boolean isPalindrome(ListNode head) {
	        if(head == null )
	        {
	            return true;    
	        }
	        //middle of the lsit
	        ListNode  slow= head;
	        ListNode  fast= head;
	        while(fast.next != null && fast.next.next != null)
	        {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        ListNode reversed = reverse(slow.next);
	        slow.next = null;
	        slow = head;
	        while(reversed != null)
	        {
	            if(slow.val != reversed.val)
	                return false;
	            slow = slow.next;
	            reversed = reversed.next;
	        }
	        return true;
	    }
	    public ListNode reverse(ListNode head)
	    {
	        if(head == null)
	            return null;
	        ListNode prev  = null;
	        ListNode curr = head ;
	        ListNode fast = head.next;
	        while(fast != null)
	        {
	            curr.next = prev;
	            prev = curr;
	            curr = fast;
	            fast = fast.next;
	        }
	        curr.next = prev;
	        return curr;
	    }
}
//Time Complexity : O(n) for finding middle of the list, O(n) for reversing the list and another O(n) for checking if the list is palindrome. Totally - O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
	//middle of the list
	//reverse
	// compare