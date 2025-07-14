// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I went to the mid and reversed it from mid to end. Now move ahead each node from head and mid head, comparing them till I reach end of the list. If they are not equal, it is not a palindrome.

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
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while(slow!=null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        while(prev!=null){
            if(prev.val!=head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}