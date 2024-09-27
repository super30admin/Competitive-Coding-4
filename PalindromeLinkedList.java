// Time Complexity : O(n)
// Space Complexity : O(n) Since used recursive reverse operation, if used three pointers to reverse it will come down to O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next; 
        }
        ListNode rev = reverse(slow);
        ListNode temp = head; 
        while(rev != null && temp != null){
            if(rev.val != temp.val) return false;
            temp = temp.next;
            rev = rev.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode node){
        if(node == null || node.next == null) return node;
        ListNode node1 = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return node1;
    }
}
