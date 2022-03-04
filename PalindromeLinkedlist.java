// Time Complexity :O(n) 
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode halfList = slow.next;
        ListNode prev = null;
        ListNode curr = halfList;
        slow.next = null;
        
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        halfList = prev;
        while(head != null && halfList != null){
            if(head.val != halfList.val){
                return false;
            }
            else{
                head = head.next;
                halfList = halfList.next;
        }}
        return true;
    }
}