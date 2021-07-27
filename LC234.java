class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode L2 = reverse(slow.next);
        slow.next = null;
        
        ListNode L1 = head;
        
        while(L1 != null && L2 != null) {
            if(L1.val != L2.val) {
                return false;
            }
            L1 = L1.next;
            L2 = L2.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode node) {
        
        ListNode prev = null;
        ListNode curr = node;
        
        while(curr != null) {
            
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}

//Time complexity: O(n)
//Space complexity : O(1)