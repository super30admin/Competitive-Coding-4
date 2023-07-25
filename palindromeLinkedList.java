// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Find the middle of the list, reverse the second half of the list and compare the first half with the second half.
 * 2. Reverse the second half again and return the result.
 */


class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode secondHalf = reverseList(mid.next);
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        mid.next = null;
        boolean result = true;

        while(p1 != null && p2 != null){
            if(p1.val != p2.val){
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        mid.next = reverseList(secondHalf);
        return result;
    }

    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        return prev;
    }
}