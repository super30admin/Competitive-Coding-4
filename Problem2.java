// 234. Palindrome Linked List

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
        //Find Mid 
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //Reverse the list start from slow. 
        ListNode revHead = reverse(slow);
        
        while(revHead != null) {
            if(revHead.val != head.val) return false;
            else {
                revHead = revHead.next;
                head = head.next;
            }
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}

/*
Time complexity : 
O(n), where n is the number of nodes in the Linked List.

Space complexity : 
O(1). We are changing the next pointers for half of the nodes. 
This was all memory that had already been allocated, so we are not using any extra memory and therefore it is O(1).
*/
