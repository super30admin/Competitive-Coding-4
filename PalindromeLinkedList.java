// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode curr = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            curr = curr.next;
            fast = fast.next.next;
        }

        System.out.println("mid: " + curr.val);

        ListNode prev = null
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        curr = head;
        while (curr != null && prev != null) {
            if (curr.val != prev.val)
                return false;
            curr = curr.next;
            prev = prev.next;
        }
        return true;
    }
}