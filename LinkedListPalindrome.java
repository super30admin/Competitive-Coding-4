// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // return helperBruteForce(head);
        return helper(head);
        // return helperBruteForce2(head);
    }

    // private boolean helperBruteForce2(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return true;
    //     }

    //     int[] arr = new int[((int) Math.pow(10, 5) + 2)];

    //     ListNode temp = head;
    //     int size = 0;

    //     while (temp != null) {
    //         arr[size++] = temp.val;
    //         temp = temp.next;
    //     }
    //     int mid = size / 2;
    //     for (int i = 0; i < mid; i++) {
    //         if (arr[i] != arr[--size]) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    // private boolean helperBruteForce(ListNode head) {
    //     if (head.next == null) {
    //         return true;
    //     }

    //     int len = 0;
    //     ListNode temp = head;
    //     while (temp != null) {
    //         len++;
    //         temp = temp.next;
    //     }

    //     int i = 0;
    //     int mid = len / 2;
    //     temp = head;

    //     while (i <= mid) {
    //         ListNode startNode = getNthPosNode(i, len, head, false);
    //         ListNode endNode = getNthPosNode(i, len, head, true);

    //         if (startNode.val != endNode.val) {
    //             return false;
    //         }
    //         i++;
    //     }

    //     return true;
    // }

    // private ListNode getNthPosNode(int pos, int n, ListNode head, boolean fromBehind) {

    //     ListNode temp = head;
    //     int targetPos = fromBehind ? n - pos - 1 : pos;
    //     for (int i = 0; i < targetPos; i++) {
    //         temp = temp.next;
    //     }
    //     return temp;
    // }

    private boolean helper(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = reverseList(slow);
        slow.next = null;
        slow = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }

            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = null;

        while (curr != null) {
            fast = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fast;
        }

        return prev;
    }
}