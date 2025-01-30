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
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public boolean isPalindrome(ListNode head) {
        // find mid 
           if (head == null || head.next == null) return true; 

       ListNode track = head;
       ListNode slow = head;
       while (track.next != null && track.next.next != null) {
            track = track.next.next;
            slow= slow.next;
            }
        //reverse till mid Point
        ListNode endSlow = slow;
        ListNode dummy = null;
        track = slow;
        while (track != null){
            ListNode temp = track.next;
            track.next = dummy;
            dummy = track;
            track = temp;
        }

        while (head != null){
            if (head.val != dummy.val){
                return false;
            }
            head = head.next;
            dummy = dummy.next;
        }
        return true;


    }
}