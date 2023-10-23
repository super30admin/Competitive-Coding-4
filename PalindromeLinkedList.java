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

 /* Time Complexity : O(n)
  *  n - lenghth of the linked list */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return true;

        //Mid of the list
        ListNode sp = head;
        ListNode fp = head;

        while(fp.next != null && fp.next.next!= null){
            sp = sp.next;
            fp = fp .next.next;
        }

        //reverse 2nd half of list
        fp = reverseList(sp.next);
        sp.next = null;

        //Compare the lists
        sp = head;
        while(fp != null){
            if(sp.val != fp.val){
                return false;
            }
            sp = sp.next;
            fp = fp.next; 
        }
        return true;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        //if(head.next == null) return head;
        ListNode temp = head.next;

        while(temp != null){
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }
        curr.next = prev;

        return curr;
    }
}