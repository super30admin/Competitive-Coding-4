/**
Time Complexity: O(N)
Space Complexity: O(N)
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
        ListNode slow = head, fast = head;
        
        if(head == null || head.next == null)
            return true;
        
        while(fast.next !=null && fast.next.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode reverse_second = reverseList(slow.next);
        
        //check for palindrome
        
        ListNode p1 = head;
        ListNode p2 = reverse_second;
        boolean result = true;
        while(result && p2!=null)
        {
            if(p1.val != p2.val)
                result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return result;
    }
    
    private ListNode reverseList(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}