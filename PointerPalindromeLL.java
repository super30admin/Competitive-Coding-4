// Time Complexity : O(n). n is the number of nodes in a Linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

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
class Solution {
     ListNode extraPtr,middle;
	    public boolean isPalindrome(ListNode head) {
	        if(head==null || head.next==null) return true;
	        
	        ListNode first=head,last=head;
	        middle=head;
	        ListNode last1=null;
	        boolean isPal =true;
	        
	        while(last!=null && last.next!=null){
	        	last1=middle;
	            middle=middle.next;
	            last=last.next.next;
	        }
	        last1.next=null;

	        ListNode prev=null; ListNode currNode=middle;
	        while(currNode!=null){
	            ListNode nextNode = currNode.next;
	            currNode.next=prev;
	            prev=currNode;
	            currNode = nextNode; 
	        }
	        
	        
	        while(prev!=null){
                if(prev!=null && first==null) return true;
	            if(first.val==prev.val){
	                first=first.next;
	                prev=prev.next;
	              //isPal = true;  
	            } else{
	                isPal= false;
	                break;
	            }
	        }
	        
	        return isPal;
	    }
    
    
}
