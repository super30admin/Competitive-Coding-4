// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
// Your code here along with comments explaining your approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = reverse(slow.next);
        slow.next = null;
        fast = head;
        while(mid != null){
            if(fast.val != mid.val) return false;
            fast = fast.next;
            mid = mid.next;
        }

        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}
