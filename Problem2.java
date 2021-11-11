// Palindrome LL
// Time O(n)
// Space O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        if (head.next == null){
            return true;
        }
        
        while(fast != null && fast.next != null){
            
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast == null){
//             LL is even len
            prev.next = null;
            
            ListNode head2 = reverseLL(slow);
            
            ListNode ptr1 = head;
            ListNode ptr2 = head2;
            
            while(ptr2 != null){
                
                if (ptr2.val != ptr1.val){
                    return false;
                }
                
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }else{
            
            prev.next = null;
            ListNode temp = slow.next;
            slow.next = null;
            
            ListNode head2 = reverseLL(temp);
            
            ListNode ptr1 = head;
            ListNode ptr2 = head2;
            
            while(ptr2 != null){
                
                if (ptr2.val != ptr1.val){
                    return false;
                }
                
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            
        }
        
        return true;
    }
    
    private ListNode reverseLL(ListNode slow){
        
        ListNode prev = null;
        ListNode curr = slow;
        
        while(curr != null){
            
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}