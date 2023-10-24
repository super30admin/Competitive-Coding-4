// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public boolean isPalindrome(ListNode head) {
       ListNode fast = head, slow = head;
       while(fast!=null && fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;
       }
       ListNode prev = slow;
       slow = slow.next;
       prev.next = null;
       while(slow!=null){
           ListNode temp = slow.next;
           slow.next = prev;
           prev = slow;
           slow = temp;}
       fast = head;
       slow = prev;
       while(slow!=null){
            if(slow.val != fast.val)
                return false;
            fast = fast.next;
            slow = slow.next;
       } 
       return true;
    }
}