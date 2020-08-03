Recursive
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode pointer;
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        pointer = head;
        return helper(head);
    }
    
    public boolean helper(ListNode current)
    {
        if(current != null)
        {
            if(!helper(current.next)) return false;
            if(current.val != pointer.val) return false;
            pointer = pointer.next;
            
        }
        return true;
    }
}


Two Pointer
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reverse(slow);
        fast = head;
        
        while(slow != null)
        {
            if(slow.val != fast.val)
            {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
            
        }
        return true;
        
    }
    
    public ListNode reverse(ListNode head)
    {
        ListNode prev =null;
        while(head != null)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}


