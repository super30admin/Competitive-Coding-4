// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


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
        if(head == null)
            return true;
        
        ListNode slow = head, fast = head;
        
        //mid point
        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;   
        }
        
        fast = reverseList(slow.next);
        //disconect first half list
        slow.next = null;
        slow = head;
        
        while( slow != null && fast != null){
            if(slow.val != fast.val){
                return false;
            } else{
                slow = slow.next;
                fast = fast.next;
            }
        }
        return true;
    }
    
    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev = null, slow=head,fast = head.next;
        
        while(fast != null){
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }
        
        slow.next = prev;
        return slow;
    }
}