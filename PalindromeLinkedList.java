/**
Daily Problem #54
Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this: 
    I had trouble coming up with an alogirithm to reverse the linked list, 
    but after 4 failed submission I figured it out without having to look it up.
    Also I had to debug my code to get it to run, my initial solution had null
    pointer exceptions
    My initial solution which passed all test cases was O(N) space using a stack
    Total time I spent on this problem was about 1 hour
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        
        boolean palindrome = true;
        ListNode originalHead = head;
        ListNode reverseHead = null;
        ListNode previous = null;
        int length = 0;
        
        // Determine length of linked list
        while(head != null){
            length++;
            head = head.next;
        }

        head = originalHead;
        int i = 0;
        
        // Reverse second half of linked list
        while(head != null) {
            if(i >= length/2){
                reverseHead =  new ListNode(head.val);
                if(previous != null){
                    reverseHead.next = previous;
                }
                previous = reverseHead;
                head = head.next;   
            }
            i++;
        }
        
        // Compare reversed second half with first half of original linkedList
        while(reverseHead != null){
            if(reverseHead.val != originalHead.val){
                palindrome = false;
                break;
            }
            reverseHead = reverseHead.next;
            originalHead = originalHead.next;
        }
        
        return palindrome;
    }
}
