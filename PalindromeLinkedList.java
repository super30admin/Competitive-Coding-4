// Approach 1
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
// Time complexity = O(n)
// space complexity = O(1).
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // steps to follow.
        // get the middle . break the list to list1 and list2
        // reverse the list 2
        // iterate through list 1 and list 2
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while(fast!=null && fast.next!=null) {
            prev =slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the middle
        // but if it is odd, do I need to compare the addl node. I don't.
        // list is odd.
        if(fast!=null && fast.next == null) {
            slow = slow.next;
        }
        // reverse the list from slow to null (the end of the list)
        ListNode dummy = null;
        while(slow!=null) {
            ListNode temp = slow.next;
            slow.next = dummy;
            dummy = slow;
            slow = temp;
        }
        // reverse done of list2.
        // now comparison of list1 and list2
        prev.next = null;
        while(head!= null  && dummy!=null) {
            if(head.val != dummy.val ) {
                return false;
            }
            head = head.next;
            dummy = dummy.next;
        }
        return true;
    }
}