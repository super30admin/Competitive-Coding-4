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

 // Time Complexity = O(N)
 // Space Complexity = O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseList(slow.next);
        slow = head;
        ListNode temp = head;
        
        while(fast != null){
            if(slow.val == fast.val){
                slow = slow.next;
                fast = fast.next;
            }
            else return false;
        }
        return true;
    }
    
    private ListNode reverseList(ListNode root){
        if(root == null || root.next == null) return root; 
        
        ListNode prev = null;
        ListNode curr = root;
        ListNode forw = root.next;
        
        while(forw != null){
            curr.next = prev;
            prev = curr;
            curr = forw;
            forw = forw.next;
        }
        curr.next = prev;
        return curr;
    }
    
}