
// Time Complexity : O(n)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes

class Solution {
    
    public boolean isPalindrome(ListNode head) {
        //edge case
        if(head == null || head.next == null) return true;
        
        //middle element
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null  && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow = head;
        
        while(slow != null && fast != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode fast = curr.next;
        ListNode prev = null;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        
        return curr;
    }
}