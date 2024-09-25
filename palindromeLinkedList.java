// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Find the middle element. 
2. Seperate the Linked List into two parts.
3. Reverse the second linked list.
4. Now compare them to see if they're a palindrome.
*/

// Your code here along with comments explaining your approach
class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = 1;
        boolean haPalindrome = false;
        ListNode slow = head;
        ListNode fast = head;
        ListNode secondHead = head;
        
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        secondHead = slow.next;
        slow.next = null;
        
        
        secondHead = reverseLinkedList(secondHead);
        // System.out.print(secondHead.val);
        
        while(secondHead!=null) {
            if(secondHead.val != head.val) return false;
            secondHead = secondHead.next;
            head = head.next;
        }
            
        return true;
    }
    
    public ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode after = head.next;
        
        while(after!=null) {
            curr.next = prev;
            prev = curr;
            curr = after;
            after = after.next;
        }
        curr.next = prev;
        return curr;
    }
}
