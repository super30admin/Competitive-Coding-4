/*

Time: O(N), N is # of nodes in the list 
Space: O(1)
Passed All Test Cases 

*/

class Solution {
    public boolean isPalindrome(ListNode head) {
     //edge case 
        if (head == null || head.next == null) return true ; 
        
        ListNode half = getHalf(head) ; 
        ListNode secondHalf = reverse(half.next) ; 
        
        ListNode p1 = secondHalf ; 
        ListNode q1 = head ; 
        
        while(p1 != null) {
        if (p1.val != q1.val) return false ; 
            p1 = p1.next ; 
            q1 = q1.next ; 
        }

        half.next = reverse(secondHalf) ; 
        return true ; 
    }
    
    private ListNode reverse(ListNode head) {
          //edge cases 
        if (head == null || head.next == null) return head ; 
        
        ListNode prev = null ; 
        ListNode curo = head ; 
        ListNode temp = head ; 
        
        while (curo != null) {
            temp = curo.next ; 
            curo.next = prev ; 
            prev = curo ; 
            curo = temp ; 
        }

        return prev ; 
    }
    
    private ListNode getHalf(ListNode head) {
        ListNode fast = head ; 
        ListNode slow = head ; 
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next ; 
            fast = fast.next.next ; 
        }
        
        return slow ; 
    }
}