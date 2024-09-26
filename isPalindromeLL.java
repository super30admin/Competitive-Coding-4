// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public boolean isPalindrome(ListNode head) {
        //base
        if(head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        //find middle
        while(fast.next != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the right half
        slow.next = reverseList(slow.next);
        //move slow to right half
        slow = slow.next;
        
        //check for left half right half equal or not
        while(slow!=null){
            if(head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre= head;
            head=next;
        }
        return pre;
    }
}