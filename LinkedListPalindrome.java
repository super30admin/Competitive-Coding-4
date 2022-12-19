// Time Complexity : O(N) 
// Space Complexity :O(1)
//Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

public class LinkedListPalindrome {
	  public boolean isPalindrome(ListNode head) {
	      
	        if(head==null)
	            return true;
	        
	        ListNode slow = head;
	        ListNode fast = head;
	        ListNode rhead = null;
	        while(fast!=null && fast.next!=null)
	        {
	            slow = slow.next ;
	            fast = fast.next.next;
	        }
	        if(fast==null){
	            rhead = reverse(slow);
	        }else{
	            rhead = reverse(slow.next);
	        }
	       
	        slow = head;
	        
	        while(rhead!=null){
	           if(slow.val != rhead.val)
	               return false;
	            rhead = rhead.next;
	            slow = slow.next;    
	        }
	        return true;
	    }
	    
	    private ListNode reverse(ListNode head){
	        ListNode pre = null;
	         ListNode slow = head;
	        while(slow!=null){
	            ListNode temp = slow.next;
	            slow.next = pre;
	            pre = slow;
	            slow = temp;
	        }
	        
	        return pre;
	    }
	    
}
