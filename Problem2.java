//Time Complexity: O(n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2 {

    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)
            return true;
        
        //find middle
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            
            fast = fast.next.next;
            slow = slow.next;
        }
            
        System.out.println(slow.val);
        //reverse second half
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        System.out.println(fast.val);
        //check if palindrome
        
        while(fast != null && slow != null){
            if(fast.val != slow.val)
                return false;
            
            fast = fast.next;
            slow = slow.next;
        }
        
            return true;
        
    }
    
    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while(fast != null){
            
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        
        return curr;
    }
}
