// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Slight complexity in handling odd-length lists during middle detection.

// Approach : 
// 1. Use fast and slow pointers to find the middle while reversing the first half of the list.
// 2. If the list has odd length, move slow one step forward to skip the middle element.
// 3. Compare the reversed first half with the second half to check if it's a palindrome.


public class PalindromeLinkedList {
    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class Solution 
    {
        public void print(ListNode head)
        {
            while(head !=null)
            {
                System.out.print(head.val+" -> ");
                head = head.next;
            }   
            System.out.println("");
        }
        public boolean isPalindrome(ListNode head) 
        {
            ListNode fast = head;
            ListNode slow = head;
            ListNode slow2 = head;
            ListNode prev = null;
            while(fast != null && fast.next != null)
            {
                slow2 = slow2.next;
                fast = fast.next.next;
                ListNode temp = slow.next;
                slow.next = prev;
                prev= slow;
                slow = temp;
            }   
            if(fast !=null && fast.next == null)
            {
                slow2 = slow2.next;
            }
            while(slow2 != null)
            {
                if(slow2.val != prev.val)
                {
                    return false;
                }
                slow2 = slow2.next;
                prev = prev.next;
            }
            return true;
        }
    }
}
