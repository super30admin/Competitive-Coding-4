//Time complexity: O(n)
//Space complexity: O(1)
//Executed on linked list

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
        if(head==null)
            return true;
        if(head.next==null)
            return true;
        /*if(head.next.next==null)
        {
            if(head.val==head.next.val)
                return true;
            else
                return false;
        }*/
        
        ListNode fast = head;       //Dividing the linked list to 2 halves 
        ListNode slow = head;       //and reversing the second half and comparing with first part.
        int i=0;
        while(!(i==2 || i==3))      //if same returns true else false.
        {
            fast = fast.next.next;
            if(fast!=null)
            {
                slow = slow.next;
            }
            if(fast==null)
                i=3;
           else if(fast.next==null)
                i=2;                
        }
        if(i==3)
            fast = reverse(slow.next);
        else
            fast = reverse(slow);
        slow.next = null;
        slow = head;
        
        while(slow!=null)
        {
            if(slow.val!=fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    ListNode reverse(ListNode slow)
    {
        if(slow==null)
            return null;
        ListNode temp =null;
        ListNode next = slow.next;
        while(slow.next!=null)
        {
            slow.next = temp;
            temp = slow;
            slow = next;
            next = slow.next;
        }
        slow.next=temp;
        
        return slow;
    }
}