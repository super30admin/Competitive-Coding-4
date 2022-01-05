// Time Complexity : O(n)
// Space Complexity : O(1)
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        // find mid point of list
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse second half of the list
        fast = reverse(slow); // fast == L2
        slow.next = null;
        
        // reset slow to head
        slow = head; // L1
        while(slow != null && fast != null)
        {
            if(slow.val != fast.val)
                return false;
            
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode prev = null, curr = head, forw = head.next;
        
        while(forw != null)
        {
            curr.next = prev;
            prev = curr;
            curr = forw;
            forw = forw.next;
        }
        curr.next = prev;
        
        return curr;
    }
}
