//Linked List Palindrom - probably should have figued out a better way to find the mid point. 

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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true; 
        
        //Determine if its odd or even 
        ListNode temp = head;
        int size = 0;
        
        while(temp != null){
            temp = temp.next;
            size++;
        }
        
        // 1 -> 2 -> 1
        // length = 3
        // 3/2 = 1
      
        //mid +1 
        int mid = size/2;
            
        //If it is odd
        if(size % 2 != 0){
            ListNode oddMid = head;

            for(int i = 0; i <= mid; i++){
                oddMid = oddMid.next;
            }
            
            ListNode reversedRight = reverse(oddMid); 
            // 1 -> 1 -> 2 -> 1 -> 1
            ListNode leftSide = head;
            
            for(int i = 0; i < mid; i++){
                if(leftSide.val != reversedRight.val) return false;
                leftSide = leftSide.next;
                reversedRight = reversedRight.next;
            }
            
        }else{
            //If it is even
            ListNode evenMid = head;

            for(int i = 0; i < mid; i++){
                evenMid = evenMid.next;
            }
            
            ListNode reversedRight = reverse(evenMid); 
            // 1 -> 1 -> 2 -> 1 -> 1
            ListNode leftSide = head;
            
            for(int i = 0; i < mid; i++){
                if(leftSide.val != reversedRight.val) return false;
                leftSide = leftSide.next;
                reversedRight = reversedRight.next;
            }
        }
        
        return true;
        
    }
    
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        } 

        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
}