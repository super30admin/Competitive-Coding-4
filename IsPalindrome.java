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
//Time: O(n)
//Space: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        
        ListNode prev = null;
        ListNode cur = mid.next;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        ListNode pal1 = head;
        ListNode pal2 = prev;
        boolean result = true;
        
        while(pal2 != null){
            if(pal1.val != pal2.val)
                return false;
            pal1 = pal1.next;
            pal2 = pal2.next;
        }
        return result;
    }
}
