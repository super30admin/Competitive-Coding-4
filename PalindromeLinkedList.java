// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class PalindromeLinkedList {
	 public boolean isPalindrome(ListNode head) {
	        ListNode slow=head;
	        ListNode fast=head;
	        
	        while(fast.next!=null && fast.next.next!=null){
	            fast=fast.next.next;
	            slow=slow.next;
	        }
	        
	        if(fast.next!=null){
	            fast=fast.next;
	        }
	        
	        ListNode head1=reverse(slow.next);
	        
	        while(head1!=null && head!=null){
	            if(head1.val!=head.val){
	                return false;
	            }
	            head1=head1.next;
	            head=head.next;
	        }
	        
	        return true;
	    }
	    
	    
	    public ListNode reverse(ListNode head){
	        if(head==null) return head;
	        ListNode prev=null;
	        ListNode curr=head;
	        ListNode next=head.next;
	        while(curr!=null){
	            curr.next=prev;
	            prev=curr;
	            curr=next;
	            if(next!=null){
	            next=next.next;
	            }
	        }
	        return prev;
	    }
	    
	    public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	   }
}
