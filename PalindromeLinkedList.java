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
        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        temp = reverse(temp);
        while(head!=null && temp!=null){
            if(head.val != temp.val){
                return false;
            }
            head = head.next;
            temp = temp.next;
        }
        return true;
    }
    private ListNode reverse(ListNode temp) {
        if(temp == null ||temp.next==null){
            return temp;
        }
        
        ListNode left = temp;
        ListNode curr = temp.next;
        ListNode right = temp.next.next;
        left.next = null;
        while(right!=null){
            curr.next = left;
            left = curr;
            curr = right;
            right = right.next;
        }
        curr.next = left;
        
        return curr;        
    }
}
