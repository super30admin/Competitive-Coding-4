//Time Complexity: O(N) where N is the number of nodes
//Space Complexity: O(1)

//Successfuly runs on leetcode: 2 ms

//Approach: To find if the List is palindrome or not, we need to see if the reverse of the list is same as the original list.
//A more optimised way is to reverse the list from the middle and compare the two sublists - if they are exactly same then
//the list is palindrome


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
        if(head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode reversed = reverse(slow.next);
        slow = head;
        fast = reversed;
        
        while(slow != null && fast != null)
        {
            if(slow.val != fast.val)
                return false;
            else
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return true;
    }
    
    private ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode curr = node;
        ListNode temp = curr.next;
        
        while(temp != null)
        {
            curr.next = prev;
            prev = curr;
            curr = temp;
            temp = temp.next;
        }
        
        curr.next = prev;
        return curr;
    }
}