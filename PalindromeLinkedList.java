// Time Complexity : O(N) where N is no of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) {
            return true;
        }

        ListNode temp = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        if(fast == null) {
            return head.val == head.next.val;
        }
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast.next !=null && fast.next.next == null) {
                fast = fast.next;
            }
        }
        ListNode newTemp = slow.next;
        ListNode prev = null;
        ListNode curr = newTemp;
        while (curr != null) {
            ListNode nextNew = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNew;
        }
        while(temp != null && prev != null) {
            if(temp.val != prev.val) {
                return false;
            }
            temp = temp.next;
            prev= prev.next;
        }

        return true;
    }
}