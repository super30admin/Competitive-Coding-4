// Time Complexity : O(N)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)   return true;
        return helper(head);
    }
    
    public boolean helper(ListNode head){
        //Find middle node
        //Reverse the half of list after mid
        //Merge 2 halfs for resultant ordered list
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){//Finding middle of the list
            slow = slow.next;
            fast = fast.next.next;
        }
        //Slow is at middle node of the list
        fast = reverseList(slow.next); // FAST will be pointing to the head of reverese list after middle node
        
        slow.next = null;
        slow = head;// Slow pointing to head of list
        
        while(fast != null){// Till the secood list not reach to null, simply set the next pointer link and merge them one by one
            if(slow.val == fast.val){ // If both values same -> Go to next pointer
                slow = slow.next;
                fast = fast.next;
            }
            else{//Otherwise return false, List is not palindrome
                return false;
            }
        }
        return true; // List is palindrome
    }
    public ListNode reverseList(ListNode head){// Reverse the list after middle node
        if(head == null)    return head;
        
        ListNode prev = null, curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}

