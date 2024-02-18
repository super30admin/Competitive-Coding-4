// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*  Your code here along with comments explaining your approach.Use two pointers to determine the middle position from which the list reverses. Reverse the list from the middle point and compare with the other half.
*/

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Determine the Middle element of the linked list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Slow pointer points to the reversed part of the linked list
        // Fast pointer points to the head of the not reversed part.
        slow = reverse(slow);
        fast = head;

        // Iterate the two parts of the linked list and compare values
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    // Reverse the linked-list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}