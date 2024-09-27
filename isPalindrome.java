// Time Complexity :O(n) n is the number of nodes in the linked list
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public boolean isPalindrome(ListNode head) {
        //edge case
        if(head == null || head.next == null) return true;
        
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        fast = reverse(mid);
        slow.next = null;
        slow = head;
        
        while(fast!=null){
            if(slow.val != fast.val)return false;
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
        
    }
    
    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
