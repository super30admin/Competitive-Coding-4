/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
*/


//T: O(n)
//S: O(1)
// Traverse till the middle of the list and also reverse the first half of the list
// Then compare the first reverse half with the second half

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode next, slow = head, fast = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            
            // Fast pointer 
            
            fast = fast.next.next;
            
            // Reverse the first half of the list
            
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        //If we have odd number of elements
        
        if(fast != null){
            slow = slow.next;
        }
        //The reversed first half head is now at prev
        //The beginning of the second half is at slow.
        
        while(prev != null && (prev.val == slow.val)){
            
            prev = prev.next;
            slow = slow.next;
        }
        
        return prev == null;
    }
}