/**
Time complexity: O(N) where N is number of nodes in linkedlist
Space complexity: O(N) for reverse if recursive reverse, else O(1)
Algorithm:
=========
1. Find middle of the list using 2-pointer technique
2. Reverse the list from middle. So, now we have 2 lists, one half as-is and one half reversed to check for palindrome
3. Now, check if node values are same for 2-lists
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {  //find the middle of the list
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast != null)  slow = slow.next; //odd list size, so list has to be reversed from mid+1
        
        slow =  reverseHelper(slow);
        ListNode rev = slow;
        fast = head;
        
        while(rev != null) {            
            if(rev.val != fast.val)     // check if reverse-x and forward-x node values are equal
                return false;
            fast = fast.next;           // iterate through both the lists
            rev = rev.next;
        }
        
        return true;
    }
    
    private ListNode reverseHelper(ListNode head) {
        // edge 
        if( head == null || head.next == null) return head;
        //logic
        ListNode newHead = reverseHelper(head.next);
        //update node's next's next to node and node's next to null
        head.next.next = head; 
        head.next = null;

        return newHead;
    }
}