/**
 * Time Complexity : O(n) where n = number of nodes in Linkedlist
 * Space Complexity : O(1) by in-place reversal of second-half of linkedlist
 */
public class PalindromeLinkedList{
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null) return true;
            if(head.next==null) return true;
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next!=null && fast.next.next!=null){
                slow= slow.next;
                fast = fast.next.next;
            }
            ListNode node = reverse(slow.next);
            while(node!=null){
                if(head.val!=node.val) return false;
                head = head.next;
                node = node.next;
            }
            return true;
        }
        public ListNode reverse(ListNode head){
            ListNode prev = null;
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast!=null){
                slow.next = prev;
                prev = slow;
                slow = fast;
                fast = fast.next;
            }
            slow.next = prev;
            return slow;
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

}