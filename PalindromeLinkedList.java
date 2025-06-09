/**
 * Leetcode 234. Palindrome Linked List
 * Link: https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class PalindromeLinkedList {
    /**
     * To calculate palindrome in singly linkedlist, we will have to reverse the right half of the original
     * linked list. This can be done in O(n) time in-place, so no extra space. reverseList() does this in-place
     * by having 3 pointers (prev,curr,temp). Once done, iterate over both lists together and check if elements
     * are equal in value
     *
     * Time: O(n) Space: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {//find mid-point, precisely the node where first list ends
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverseList(slow.next);
        slow.next = null; //break links between both lists
        slow = head;

        while (fast != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode curr) { // reverse list in-place TC: O(n) SC: O(1)
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
 }
