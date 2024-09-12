// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean isPalindrome(ListNode head) {
               // s
        // 1 2 3                   
        // 1 2 null
        //p c  a
        
        if(head == null || head.next == null)
            return true;
        
        ListNode mid = findMid(head);
        ListNode temp = mid.next;
        mid.next = null;
        
        ListNode rev = reverseList(temp);
        
        return equalList(head, rev);        
    }
    
    public ListNode findMid(ListNode node) {
        
        ListNode slow = node;
        ListNode fast = node;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverseList(ListNode node) {
        
        ListNode prev = null;
        ListNode curr = node;
        
        while(curr != null) {
            ListNode next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;            
        }
        
        return prev;
    }
    
    public boolean equalList(ListNode nodeA, ListNode nodeB) {
        
        while(nodeA != null && nodeB != null) {
            if(nodeA.val != nodeB.val)
                return false;
            
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }        
        
        return true;
    }
    
}