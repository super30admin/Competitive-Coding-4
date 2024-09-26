// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head==null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Find middle of linked list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // reverse second half
        if(fast!=null) slow=slow.next;
        slow = reverse(slow);
        
        // compare both halves of list
        while(slow!=null) {
            
            if(head.val!=slow.val) return false;
            head=head.next;
            slow=slow.next;
            
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null) {
            
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            
        }
        return prev;
        
    }
    
}
