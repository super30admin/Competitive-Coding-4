// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isPalindrome(ListNode head) {
        //base case if the head is null or if the head is the only node
        if(head == null || head.next == null)
            return true;
        
        //reaching midpoint
        ListNode slow = head, fast = head;
        
        //slow moves one step and fast moves two steps so fast reaches the end in half the time
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second half of the linked list
        ListNode prev = null, curr = slow;
        fast = curr.next;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        
        //compare if the first half of the list is the same as the second half
        slow = head;
        
        while(slow != null && curr != null){
            
            if(slow.val == curr.val){
                slow = slow.next;
                curr = curr.next;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}




