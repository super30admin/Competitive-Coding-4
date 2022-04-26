// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = reverse(slow.next);
        slow = head;
        while(fast!=null){
            if(slow.val!=fast.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode prev = null;
        ListNode next = head.next;
        while(next!=null){
            head.next = prev;
            prev = head;
            head = next;
            next = next.next;
        }
        head.next = prev;
        return head;
    }
}