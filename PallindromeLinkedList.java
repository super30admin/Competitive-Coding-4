/*
    Space complexity : O(N)
    time complexity :  O(N)
    worked on leetcode : YES

*/

public class PallindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        
        if ( head == null ) return true;
        ListNode slow = head;
        ListNode fast =head;
        
        while( fast.next!= null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        
        
        ListNode rev_head = reverse(mid.next);
        mid.next = null;
        
        
        while(head != null && rev_head != null ){
            if(head.val != rev_head.val) {
                return false;
            }
            else{
                head =  head.next;
                rev_head =  rev_head.next;
            }
        }
        
        return true;
        
    }
    
    private ListNode reverse(ListNode head){
        // 1-> 2 > 3 - > 4
        if (head == null) return null;
        ListNode prev =  null;
        ListNode cur = head;
        ListNode next_ptr = head.next;
        
        while(next_ptr != null){
            cur.next = prev;
            prev = cur;
            cur = next_ptr;
            next_ptr = next_ptr.next;
        }
        cur.next = prev;
        
        return cur;
        
        
        
    }
}