// 234. Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list/

//The time complexity is O(n), n is the number of nodes in the Linked List.
//Space complexity: o(N) The recursion stack may go up to O(n) if the tree is unbalanced.

/*
Method 1: Brute force approach:
1. Create a list/arraylist and copy the elemenets. 
then reverse the elements into another array list. 
Compare each element from both the lists 
and if same, return true else return false.
Time complexity; O(3N) = O(n)
Space complexity: O(1)  , no space used, only pointers

Method 2: Two pointer + Reverse Second Half In-place
Find the end of the first half.(slow - xtimes, fast - 2xtimes)
-> By the time the fast runner gets to the end of the list, the slow runner will be half way, 
   to find the middle of the list, and then split the list into two halves.
   If there is an odd-number of nodes, then the "middle" node should remain attached to the first half.
Reverse the second half.
Determine whether or not there is a palindrome.
Restore the list.(Not needed - optional)
Return the result.
*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)  return true;
        
        ListNode firstHalf = firstHalfEnd(head);
        ListNode firstSecond = reverseList(firstHalf.next);
        
        boolean result = true;
        
        ListNode p1 = head;
        ListNode p2 = firstSecond;
        while(p2!=null){
            if(p1.val != p2.val) return false;
        p1 = p1.next;
        p2 = p2.next;
        }
        return result;

    }
    
    private ListNode firstHalfEnd (ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        
        while(current!=null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}