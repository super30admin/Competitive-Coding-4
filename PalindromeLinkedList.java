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
// Approach : Middle of linked list and reverse the half of LL
// Time : O(n)
// Space : O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // calculate middle of the linked list
        // move slow by 1x and fast by 2x
        // mid will be launched by slow pointer
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // Now linked list divide into two portions from middle
        // from middle to end LL reverse it.
        
        slow = reverseLL(slow);
        
        
        // After reverse , now reset the fast pointer to head of first SLL
        // now move slow and fast from two ll and compare 
        fast = head;
        while(slow!=null){
            if(fast.val != slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverseLL(ListNode root){
        if(root == null || root.next == null) return root;
        
        // Three Pointer Approach
        ListNode prev = null;
        ListNode curr = root;
        ListNode fast = root.next;

        while(fast!=null){
            curr.next = prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next = prev; // make one last connection
        return curr;
    }
}