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
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Get the middle term using fast and slow pointer
// reverse the list from the next of the mid pointer
// compare the first half and the reversed list and if both are same then its a palindrome
// Your code here along with comments explaining your approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);
        slow = head;
        while(slow != null && fast != null ){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    // to reverse the string
    private ListNode reverse(ListNode head){
        ListNode first = null;
        ListNode second = head;
        ListNode third = head.next;
        while(third != null){
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }
        second.next = first;
        return second;
    }
}