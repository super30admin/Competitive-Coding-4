// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
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
        if(head==null || head.next == null){
            return true;
        }
   
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse_head = reverseList(slow.next);
        slow.next = null;
        slow = head;
        while(slow!=null && reverse_head!=null){
            if(slow.val != reverse_head.val){
                return false;
            }
            slow= slow.next;
            reverse_head= reverse_head.next;
        }
        
        return true;
        
    }
    
    ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}