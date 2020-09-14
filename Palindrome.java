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
        
        ListNode slow =  head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode rev = reverseList(slow);
         
        slow = head;
        fast = rev;
        
        while(slow != null && fast != null){
            if(slow.val != fast.val)
                return false;
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    
        
    }
    
    public ListNode reverseList(ListNode node){
        ListNode prev = null, curr = node, next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}