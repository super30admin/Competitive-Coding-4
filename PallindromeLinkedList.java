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

    // Time Complexity : 0(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I took slow and fast pointer to figure out my mid. Then I reversed
    //the 2nd half of my list. Reset my slow pointer to the head of the reversed list and fast pointer to the head of the current
    //list. Then checked if my 1st node is equal to last node or not. Incremented the pointers simultaneously. If they are not,
    //then returned false. If they are, Then returned true.


    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        fast = head;
        while(slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = null;
        ListNode current = head;
        ListNode fast = head.next;
        while(fast != null){
            current.next = temp;
            temp = current;
            current = fast;
            fast = fast.next;
        }
        current.next = temp;
        return current;
    }
}