// Time Complexity : O(3n) = O(n), n is size of linked list 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//find mid
//reverse from mid+1
//reversed list reaches null

//odd condition :
//reversed list will have 1 less node (so will reach null sooner)

//even condition
//both list will reach null at same time



class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) return true;
        
        //find mid
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //find reverse
        fast = reverse(slow.next);
        slow.next = null; 
        slow = head;
        
        //check vals for slow ll and reversed fast ll
        while(fast != null) {
            if(slow.val == fast.val) {
                slow = slow.next;
                fast = fast.next;             
            }
            
            else {
                return false;
            }
        }
        return true;
              
        
    }
    
    //method for reverse of 2nd half of list
    private ListNode reverse (ListNode rhead) {
        ListNode prev = null;
        ListNode next1 = rhead.next;
        
        while(next1 != null) {
            rhead.next = prev;
            prev = rhead;
            rhead = next1;
            next1 = next1.next;
        }
        rhead.next = prev;
        
        return rhead; 
    }
  
    
}

