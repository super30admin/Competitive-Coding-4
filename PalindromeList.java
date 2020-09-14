// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        //1. Find Mid (slow) using Floyd algo
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next!= null){
            slow = slow.next;    
            fast = fast.next.next;
        }
        
        //2. Reverse the right side of the List
        ListNode rev = reverse(slow);
        
        //3. Compare if  the values are the same otherwise return false;
        while(rev != null){
            if(head.val != rev.val)
                return false;
            head = head.next;
            rev = rev.next;
        }    
        return true;
    }
    
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while(curr!= null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;    
    }
}