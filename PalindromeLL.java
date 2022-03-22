/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        //Find the middle
        while(fast.next!= null && fast.next.next!= null){
            slow= slow.next;
            fast= fast.next.next;
        }
     
        //reverse the linked List from the middle
        ListNode prev= null, curr= slow.next, next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Check if it is palindrome
        slow= prev;
        curr= head;
    
        while(slow!= null){
            if(slow.val!= curr.val) return false;
                slow= slow.next;
                curr= curr.next;    
        }
        return true;
    }
}

//Time complexity- O(n)
//Space complexity - O(1)