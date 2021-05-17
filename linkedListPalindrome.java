// Time complexity - O(n)
// Space complexity - O(1)
//Did this code successfully run on Leetcode : Yes 
//Any problem you faced while coding this : No

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
        
        if(head == null || head.next == null){return true;}
        
        ListNode slow = head;
        ListNode fast = head;
        
        //find mid of the linked list
        while(fast.next != null && fast.next.next != null){
            
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
            
            
        }
        //reverse the linked list after mid
        ListNode prev = slow;
        ListNode current = slow.next;
        ListNode next = slow.next;
        
        while(next.next != null){
            
            next = next.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        slow.next = null;
        slow = head;
        while(slow.next != current.next && slow.next != null){
           // System.out.println(slow.val);
           // System.out.println(current.val);
            if(slow.val != current.val){
                
                return false;
            }
            slow = slow.next;
            current = current.next;
        }
        if(slow.val != current.val){
            return false;
        }
        return true;
    }
}