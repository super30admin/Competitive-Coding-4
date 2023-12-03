// https://leetcode.com/problems/palindrome-linked-list/description/
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

//  Time Complexity: O(n)
//  Space Complexity: O(1) 
class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        while(slow != null && fast != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
        
    }
    
    ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr.next != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        return curr;
    }
    
}