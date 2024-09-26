// TC: O(N)
// SC: O(1)
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
        
        if(head == null){
            return true;
        }
        
     ListNode mid =  findMid( head);
        
     ListNode headReverse = reverse(mid);
        
       return checkPalindrome( head, headReverse , mid);
        
        
    }
    
    private ListNode findMid(ListNode head){
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
        
    }
    
    
    private ListNode reverse(ListNode mid){
        
        ListNode temp = mid.next;
        ListNode prev = null;
        ListNode current = mid;
        
        while(current != null ){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            
        }
         
        return prev;
    }
    
    
    private boolean checkPalindrome(ListNode head,ListNode headReverse, ListNode mid){
        
        boolean answer = true;
        
        while(head != mid.next && headReverse != null){
            
            if(head.val != headReverse.val){
        
                answer = false;
                break;
            }
            
            head = head.next;
            headReverse = headReverse.next;
            
        }
       
        
        return answer;
        
    }
    
    
}