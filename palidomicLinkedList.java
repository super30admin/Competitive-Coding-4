    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/palindrome-linked-list/
    Time Complexity for operators : o(3n/2) 
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Add it to the stack one by one and then create new list by popping one by one 
                            and check with thee current list and pop element one by one. o(2n) time and o(n) space
                            complexity.

        # Optimized approach same like basic approach: Recursion or Iterative.
                              
                #
                    A. find the mid of linked list by using slow and fast pointers
                    B. then  reveser the 2nd half of the list.
                    C. compare second half with first half one by one if there is any difference then 
                        return flase.
                    D. At the end, if  all matches then return true.

       */

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

   class reverseLinkedList {

        // brute force
    //        public boolean isPalindrome(ListNode head) {
        
        
    //     Stack<Integer> stack = new Stack<>();
    //     ListNode list = head;
    //     while(list!=null)
    //     {
    //         stack.push(list.val);
    //         list=list.next;
    //     }

    //     ListNode list2 = head;
    //     while(!stack.isEmpty())
    //     {
    //         if(list2.val == stack.peek())
    //         {
    //             stack.pop();
    //             list2=list2.next;
    //         }
    //         else
    //             return false;
    //     }
        
    //     return stack.isEmpty();
        
    // }


        //Optimized approach

	    public boolean isPalindrome(ListNode head) {
	    	
	    	if(head==null)
	    		return true;
	    	
	    	ListNode slow = head;
	    	ListNode fast = head;
	    	while(fast.next!=null && fast.next.next!=null) {
	    		slow  = slow.next;
	    		fast = fast.next.next; 
	    	}
	    	
	    	ListNode h2 = reverse(slow.next);
	    	slow .next = null;
	    	ListNode h1 = head;
	    	
	    	while(h2!=null) {
	    		if(h1.val==h2.val) {
	    			h1= h1.next;
	    			h2= h2.next;
	    		}
	    		else
	    			return false;
	    	}
	    	
	    	return true;
	    }
	    
	    private ListNode reverse(ListNode head) {
	    	ListNode curr = head;
	    	ListNode temp = null;
	    	ListNode prev = null;
	    	
	    	while(curr!=null) {
	    		temp = curr.next;
	    		curr.next = prev;
	    		prev = curr;
	    		curr = temp;
	    	}
	    	return prev;
	    }
}