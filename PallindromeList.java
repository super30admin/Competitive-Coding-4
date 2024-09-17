class Solution {
    
    
    private ListNode reverseList(ListNode head){
        ListNode previous = null, cur = head, next = null;
        
        while(cur != null){
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;            
        }
        return previous;
        
    }
    
    public boolean isPalindrome(ListNode head) {
        
        if(head.next == null)
            return true;
        
        ListNode fast = head, slow = head, prev = null;
        
        // find mid
        while(fast != null && fast.next != null) {
            //prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode newHead;
        
        if(fast == null){     //list has even number elements    
            newHead = reverseList(slow);           
        }
        else{                 //list has odd number elements
            newHead = reverseList(slow.next);            
        }
        
        //compare left half with reversed right half
        ListNode tmp = head;
        while(newHead != null){
            if(newHead.val != tmp.val)
                return false; 
            
            tmp = tmp.next;
            newHead = newHead.next;
        }
            
        return true;    
    }
}