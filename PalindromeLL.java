//https://leetcode.com/problems/palindrome-linked-list/
//TC: O(n)
//SC: O(1)

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
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!= null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast = reverse(slow);
        while(head!=null){
            if(head.val != fast.val) return false;
            head = head.next;
            fast = fast.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }
}
