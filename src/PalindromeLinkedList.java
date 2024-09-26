// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


/** https://leetcode.com/problems/palindrome-linked-list/
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
        
        if(head == null || head.next == null) return true;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode slow = dummy, fast = dummy;
        
        //split linkedlist from the middle, using slow and fast pointer
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head1 = head;
        ListNode head2 = slow.next;
                
        slow.next = null;
        
        ListNode prev = null;
        ListNode curr = head2;
       
        //reverse the second half
        while(curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        curr.next = prev;
        head2 = curr;
        
        //check the list1 and list2 node by node
        while(head1 != null && head2 != null) {
            if(head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
    }
}