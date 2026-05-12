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
        boolean odd = false;
        boolean flag = false;
        while(fast.next!=null && fast.next.next!= null){
            slow= slow.next;
            fast= fast.next.next;
        }
        if(fast.next==null) odd = true;
        // System.out.println(odd);
        fast= reverselist(slow.next);
        slow.next = null;
        slow = head;
        while(fast!=null){
            if(fast.val!=slow.val){
                // System.out.println(fast.val);
                // System.out.println(slow.val);
                return flag;
                }
                // System.out.println(fast.val);
                // System.out.println(slow.val);
                slow=slow.next;
                fast=fast.next;
            }
            // System.out.println(fast.val);
            // System.out.println(slow.val); 
        flag = true;
        return flag;

    }
    private ListNode reverselist(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev= curr;
            curr= temp;
        }
        return prev; 
    }
}