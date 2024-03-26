// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

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
     if(head == null || head.next == null) return true;

     ListNode slow = head;
     ListNode fast = head;

    //to get mid
     while(fast.next != null && fast.next.next != null){
        slow = slow.next;
        fast = fast.next.next;
     }

     ListNode head2 = slow.next;
     slow.next = null;

     head2 = reverse(head2);

     //check if both the lists are equal
     while(head != null && head2 != null){
        if(head.val != head2.val){
            return false;
        }
        head = head.next;
        head2 = head2.next;
     }
     return true;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode curr = head;
        ListNode prev = null;

        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = curr.next;
        } 
        curr.next = prev;
        return curr;
    }
}