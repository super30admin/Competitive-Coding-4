//Time Complexity: O(n) 
// Space Complexity: O(1) 
/* Approach : To determine if a linked list is a palindrome, we use a two-pointer technique to find the middle of the list, 
then reverse the second half. We compare the values of the nodes in the first half with those in the reversed second half. 
If all corresponding values match, the list is a palindrome; otherwise, it is not. This approach ensures that we efficiently 
check for palindromes without using extra space for storing values.
 */
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
    // Method to check if a linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        // If the list is empty or has only one node, it's a palindrome
        if (head == null || head.next == null) return true;

        // Initialize slow and fast pointers to find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        // Move slow pointer by 1 step and fast pointer by 2 steps
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        ListNode head2 = slow.next;
        slow.next = null;

        // Reverse the second half of the list
        head2 = reverseList(head2);

        // Compare the two halves
        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    // Method to reverse a linked list
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        // Reverse the pointers in the list
        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}
