// https://leetcode.com/problems/palindrome-linked-list/

// Time Complexity : O(n) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, linked list is made into 2 halves. 2nd linked list is reversed. Starting at the heads of both the linked lists, traverse along one
 * at a time by comparing the values till 2nd linked list does not reach null. If there is a mismatch return false else return true.
 */
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
        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        slow = head;
        while(prev!=null){
            if(slow.val!=prev.val) return false;
            slow=slow.next;
            prev = prev.next;
        }
        return true;
        
    }
}