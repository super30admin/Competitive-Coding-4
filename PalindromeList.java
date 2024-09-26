// Time Complexity : O(n)
// Space Complexity :O(1)

public class PalindromeList {
	public boolean isPalindrome(ListNode head) {
        ListNode slow =  head;
        ListNode fast =  head;
        
        while(fast!=null && fast.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow = reversed(slow);
        fast = head;
        
        while (slow != null){
            if (slow.val != fast.val) {
                return false;
                }
            slow =slow.next;
            fast = fast.next;
            
        }
        
        return true;
        
    }
   private ListNode reversed (ListNode head) {
        ListNode prev = null;
        ListNode fast = head.next;
        while(fast!=null){
            head.next = prev;
            prev = head;    
            head = fast;
            fast = fast.next;
            
        }
        head.next = prev;
        return head;
        
    }	
}
