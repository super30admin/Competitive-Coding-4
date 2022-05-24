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
         if(head == null) return true;
        ListNode sptr = head;
        ListNode fptr = head;
        while(fptr.next!=null && fptr.next.next!=null){
            sptr=sptr.next;
            fptr = fptr.next.next;
            
        }
        fptr = reverse(sptr.next);
        sptr.next = null;
        sptr =head;
        while(sptr!=null && fptr!=null){
            if(sptr.val != fptr.val) return  false;
            sptr = sptr.next;
            fptr = fptr.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode prev = null;
        ListNode cur = head;
        ListNode fast = head.next;
        while(fast!=null){
            cur.next = prev;
            prev = cur;
            cur = fast;
            fast = cur.next;
        }
        cur.next = prev;
        return cur;
    }
}