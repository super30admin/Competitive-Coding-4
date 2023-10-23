// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// Using slow and fast pointers traversing till mid of the LL
// From here I reversed the second part of LL
// Then traverse from start of 1st LL and from end of 2nd LL
// Meanwhile checking the elements and if any mismatch is found then returning false else truegt

class Solution {
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

    public static boolean isPalindrom(ListNode head) {

        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the link from slow ptr
        ListNode prev = null;
        ListNode curr = slow;
        ListNode temp = curr.next;
        while (temp != null) {
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }
        curr.next = prev;

        ListNode end = curr;
        ListNode start = head;

        while (end != null) {
            if (start.val != end.val) {
                return false;
            }
            start = start.next;
            end = end.next;
        }
        return true;
    }
}