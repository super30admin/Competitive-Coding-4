
//Idea: here idea is find out middle element of linked list and divide linked list into two half.
//take reverse of first half till middle and if reverse of first half is  equal to second half then linked list is palidromic.
//special case need to handle for odd and even length of linkedlist
//Time complexity : O(n)

//Space complexity : O(1)

//  Definition for singly-linked list.
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }

class Solution {
	
	/*
	//  Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }*/
	 
    public static  boolean isPalindrome(ListNode head) {
        if(head == null || head.next ==null) return true;
        if( head.next.next== null) {
            if(head.val == head.next.val) return true;
            else return false;
        }
         // calculate number of nodes
    int count = 0;
    ListNode pointer = head;
    while (pointer != null) {
        count++;
        pointer = pointer.next;
    }
        
        //calculate mid element
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid;
        
        ListNode slowprev=null;
        
        ListNode current = head;
        
        while(fast!=null && fast.next!=null){
            slowprev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
     
       
       mid = slowprev;
 
      System.out.println("mid= "+mid.val);
        
        //need to divide the list into  first half and second half
 
       // if linked list has odd number of nodes then skip center node
        
         
       // if linked list has odd number of nodes then skip center node
       ListNode  start2= count % 2 == 0 ? slowprev.next : slowprev.next.next;;
      
        mid.next =null; //first half of linklist ends
       
     
        ListNode curr = reverseList(head);
        
       
        
        while (curr!= null && start2!=null ){
            System.out.println("Curr="+curr.val);
            System.out.println("Start2="+start2.val);
          
            if (curr.val == start2.val) { 
                curr = curr.next; 
                start2 = start2.next; 
            } else{
                return false; 
            } 
            
        }
  
        /* Both are empty reurn 1*/
        if (curr == null && start2 == null) 
            return true; 
         else   return false;
        /* Will reach here when one is NULL 
           and other is not */
  
        
    }
    
    private static ListNode reverseList(ListNode head){
        
        ListNode curr = head ;//start of first linkedlist
        ListNode prev = null ; 
            
        //reverse the first half
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next ;
                        
        }
        
        return prev;
    }
}

public class PalidromicLinkedList {
	
	public static void main(String[] args) {
	
		ListNode head = new ListNode(1); 
        head.next = new ListNode(2); 
        head.next.next = new ListNode(2); 
        head.next.next.next = new ListNode(1); 
        
        boolean flag = Solution.isPalindrome(head);
        
        System.out.println("Linkedlist is parlidrome ="+flag);
        
		
	}

}
