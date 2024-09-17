/**
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
nope

// Your code here along with comments explaining your approach
//find mid of link list.
//rev the link list.
//now see if orinial and reversed have same vals.
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        //get mid.
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //rev list from mid onwards.
        ListNode prev = null;
        fast = slow;
        while(slow != null){
            fast = slow.next;
            slow.next = prev;
            prev = slow;
            slow = fast;
        }

        //see if palin.
        slow = head;
        fast = prev;
        while(slow != null && fast != null){
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
