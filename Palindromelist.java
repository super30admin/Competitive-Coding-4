/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 // find a mid
 // reverse the 2nd half of the list
 // check the palindrome with 2 ptr on both the list
 
 1 2 3
 head -> head.next
 
 TC - O(N/2) to find mid + O(N/2) for reverse + O(N/2) for palindrome check.
 SC - O(1)

 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head == null)
        {
            return true;
        }

        ListNode mid = findMid(head);
        
        System.out.println(mid.val);
        
        ListNode nextHead = mid.next;
        mid.next = null;
        
        ListNode revereHead = reverseTheList(nextHead);
        
        ListNode first = head;
        ListNode second = revereHead;
        
        while(first != null && second != null)
        {
            if (first.val != second.val)
            {
                return false;
            }
            
            first = first.next;
            second = second.next;
        }
        
        return true;
    }
    
    /**
    findMid = 1->2->3->2->1
    
    1 2 3
    **/
    private ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    
    // return head of the reveresed linked list
    private ListNode reverseTheList(ListNode head)
    {
        ListNode prev = null;
        ListNode current = head;
        
        while(current != null)
        {
            ListNode newNode = current.next;
            current.next = prev;
            prev = current;
            current = newNode;
        }
        
        return prev;
    }
}
