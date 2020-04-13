// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode secondHalf = reverseList(slow);
        
        while(head!=null && secondHalf!=null){
            if(head.val!=secondHalf.val){
                return false;
            }
            
            head=head.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
        
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}