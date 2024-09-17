
public class LinkedListPalindrome {
	
	
	class ListNode{
	
		ListNode next;
		int val;
		 ListNode(int x) { val = x; }
	}

	class Solution {
	    public boolean isPalindrome(ListNode head) {
	       
	  
	        if (head == null) return true;
	    
	        ListNode slow =head;
	        ListNode fast = head;
	        //slow fast method to find the mid point
	        while(fast.next != null && fast.next.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        ListNode head2 = slow.next;
	        slow.next =null;
	        
	        ListNode prev =null;
	        ListNode curr = head2;
	        ListNode next;
	        //reversing the second half of the LL
	        while(curr!= null){
	            next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr= next;
	        }
	        
	        head2 = prev;
	        
	        //iterating over both lists
	        while(head!=null && head2!=null){
	            if(head.val != head2.val) return false;
	            else{
	                head = head.next;
	                head2 = head2.next;
	            }  
	        }
	        return true;
	    }
	    
	}

}
