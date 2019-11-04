/**
Daily Problem #54
Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : 
    Yes Runtime: 39% faster , Memory usage 98.78% less
Any problem you faced while coding this: 
    I had trouble coming up with an alogirithm to reverse the linked list, 
    but after 4 failed submission I figured it out without having to look it up.
    Also I had to debug my code to get it to run, my initial solution had null
    pointer exceptions
    My initial solution which passed all test cases was O(N) space using a stack
    Total time I spent on this problem was about 1 hour
 */
import java.util.Stack;

class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean palindrome = true;
        ListNode originalHead = head;
        ListNode reverseHead = null;
        ListNode previous = null;
        
        // Reverse the original linked list
        while(originalHead != null) {
            reverseHead =  new ListNode(originalHead.val);
            if(previous != null){
                reverseHead.next = previous;
            }
            previous = reverseHead;
            originalHead = originalHead.next;
        }
        
        // Compare original linked list with reversed list to determine palindrome
        while(reverseHead != null) {
            if(reverseHead.val != head.val){
                palindrome = false;
                break;
            }
            reverseHead = reverseHead.next;
            head = head.next;
        }
        
        return palindrome;
    }
}
