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
// Time Complexity : O(N), N is the number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        //finding the middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondPtr = reverseList(slow.next);
        
        
        //comparing two halfs
        while(head != null && secondPtr != null) {
            if(head.val == secondPtr.val) {
                head = head.next;
                secondPtr = secondPtr.next;
            } else {
                return false;
            }
        }
        return true;
    }
    //reversing the second half
    private ListNode reverseList(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            while(curr != null) {
                ListNode temp = curr.next;
                
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
    }
}