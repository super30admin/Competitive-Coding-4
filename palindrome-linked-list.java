// Time - O(N)
// Space - O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow = head;
        
        while(fast!=null) {
            if(slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;            
        }
        
        return true;
        
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null, curr = head;
        
        while(curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }
}
