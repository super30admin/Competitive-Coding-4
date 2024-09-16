// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null)
            return true;
        
        
        ListNode mid = findMid(head);
        ListNode secondHalf = reverse(mid.next);
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;
        while(p2 != null){
            
            if(p1.val != p2.val)
                result = false;
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        mid.next = reverse(secondHalf);
        return result;
    }
    
    private ListNode findMid(ListNode head){
        
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast.next != null && fast.next.next!=null){
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
        
    }
    
    private ListNode reverse(ListNode mid){
        
        ListNode  cur = mid;
        ListNode  prev = null;
        
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
}


