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
 
 //TimeComplexity : O(n)
 //Space Complexity : O(1)
 class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode previous = null;
        while(slow != null) {
        ListNode temp = slow.next;
        slow.next = previous;
        previous = slow;
         slow = temp;
    }
     ListNode temp1 = previous;
     while(temp1 != null) {
         if(head.val == temp1.val) {
             head = head.next;
             temp1= temp1.next;
         } else {
             return false;
         }
     }
     return true;
    }
}