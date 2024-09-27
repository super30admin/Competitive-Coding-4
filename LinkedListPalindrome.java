/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 // Time Complexity : O(N)
 // Space Complexity : O(1)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy; ListNode fast = dummy;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = reverse(slow.next);
        slow.next = null;
        ListNode temp1 =  head;
        ListNode temp2 = l2;
        while(temp2!=null){
            if(temp1.val != temp2.val){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode node){
        if(node == null){
            return node;
        }
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}