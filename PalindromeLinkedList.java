// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isPalindrome(ListNode head) {
        // return true if linked list is empty or has only one element
        if(head == null) return true;
        if(head.next == null) return true;

        // intiailize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // keep moving slow and past pointers,
        // such that when fast pointer reaches end of list,
        // slow pointer is at mid point of list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow will be at mid point
        // make reference to node next to mid element
        ListNode head2 = slow.next;
        // separate two lists from mid element
        slow.next = null;
        // intialize previous, current and next pointers to reverse the second list
        ListNode previous = null;
        ListNode current = head2;
        ListNode next = current.next;
        // reverve the second list
        while(next != null){
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        head2 = current;
        // traverse through both the lnked lists
        // if value at any point differs, return false
        while(head != null && head2 != null){
            if(head.val != head2.val) return false;
            else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }
}