// Reversing the linkedlist from the mid
//comparing both the lists

//TC:O(n)
//SC: O(n)

public class LinkedListPalindrome {

     public class ListNode {
             int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public boolean isPalindrome(ListNode head) {
         
            if(head == null || head.next == null) return true;
    
             //finding the middle 
            ListNode slow = head;
            ListNode fast = head;
    
            while(fast.next!=null && fast.next.next!=null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
    
            //placing fast back at mid+1 
            fast = slow.next;
    
            //reversing the remaining list
            ListNode prev = null;
            ListNode curr = fast;
            fast = fast.next;
    
            while(fast != null)
            {
                curr.next = prev;
                prev = curr;
                curr = fast;
                fast = fast.next;
            }
    
            curr.next = prev;
            //Comparing with the reversedLinkedList
    
            ListNode prev_list = head;
            ListNode rev_list = curr;
    
            while(rev_list!=null)
            {
    
                if(prev_list.val != rev_list.val){
                    return false;
                }
    
                prev_list = prev_list.next;
                rev_list = rev_list.next;
            }
    
           return true;
        }
    }
    
}
