
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
       if(head == null || head.next == null) return;
    
        ListNode slow = head;
        ListNode fast = head.next;
        
        //find mid node 
        while(fast!=null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;  
        }
        
        //cut half
        ListNode head2 = slow.next;
        slow.next = null;
        
        //reverse
        ListNode prev = null;
        ListNode curr = head2;
        ListNode next;
        
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;
        
        //check node values
        
    
        return true;
    }
}
