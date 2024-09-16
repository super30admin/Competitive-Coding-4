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
// Any problem you faced while coding this : Some problems finding the mid of the linked list.

class PalindromLL {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        //finding the mid of the linkedlist
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        ListNode next;
        //Reversing the mid-end linkedlist
        while(curr!=null){
            //System.out.println(next.val);
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //curr.next = prev;
        // System.out.println(head.val);
        // System.out.println(head.next.val);
        // System.out.println(fast.val);
        // System.out.println(fast.next.val);
        fast = prev;

        //checking if both the linked list are equal!!
        while(fast!=null && head!=null){
            if(head.val!=fast.val){
                return false;
            }
            else{
                head = head.next;
                fast = fast.next;
            }
        }
        return true;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }