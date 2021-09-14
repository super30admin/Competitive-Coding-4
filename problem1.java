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
        if(head == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reverse(slow);
        fast = head;
        
        while(slow != null && fast != null)
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
        ListNode prev = null;
        ListNode current = head;
        ListNode fast = current.next;
        
        while(fast != null)
        {
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        
        current.next = prev;
        
        return current;
    }
}

//space complexity O(1)
//time complexity O(N)