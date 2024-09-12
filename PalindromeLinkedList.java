// Time Complexity : O(n)
// Space Complexity : O(1)
public class PalindromeLinkedList {	
	/** Definition for singly-linked list. **/
	 static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	 /**Reverse second half the list**/
	 public boolean isPalindrome(ListNode head) {
	        boolean flag=true;
	        if(head==null || head.next==null) return true;
	        
	        //Find mid
	        ListNode curr= head;
	        ListNode fast= curr.next;        
	        while(fast!=null && fast.next!=null){
	            curr= curr.next;
	            fast= fast.next.next;
	        }
	        //reverse the second half
	        fast= reverse(curr.next);
	        
	        //sever the list in two and compare nodes in both the lists
	        curr.next=null;
	        curr=head;        
	        while(curr!=null && fast!=null){
	            if(curr.val!=fast.val){
	                flag=false;
	                break;
	            }
	            curr=curr.next;
	            fast=fast.next;
	        }
	        
	        return flag;        
	    }
	    
	    private ListNode reverse(ListNode head){
	        ListNode prev= null;
	        ListNode curr= head;
	        ListNode fast= head.next;        
	        while(fast!=null){
	            curr.next= prev;
	            prev=curr;
	            curr=fast;
	            fast=fast.next;
	        }
	        curr.next=prev;
	        return curr;
	    }
	 
	 public static void main (String[] args) {
		 PalindromeLinkedList ob = new PalindromeLinkedList();
		ListNode l1= new ListNode(1, new ListNode(2,new ListNode(2,new ListNode(1))));				
		
		System.out.print("Is Linked list Palindrome?:"+ ob.isPalindrome(l1));			
	}
}
