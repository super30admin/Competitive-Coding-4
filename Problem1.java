// Time Complexity : is O(n)
// Space Complexity is  O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        //base case
        if(head == null  ) return true;
        
        if(head.next == null  ) return true;
        
        // First we get the mid.
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next; //reset fast to slow pointer
        slow.next  = null; // break the list
        //divide list in to two parts
        // reverse the other list from fast pointer
         
       
        ListNode prev = null;
        while(fast!=null){
          ListNode tmp = fast.next;  
          fast.next = prev;
          prev = fast;
          fast = tmp;  
        }
       
        // Now we need to check slow and fast pointer to have same values
        while ( head!=null &&  prev!=null){
             if(head.val!= prev.val) return false;
             else{
                 head = head.next;
                 prev = prev.next;
             }
        }
        
        return true;
        
        
    }
}
