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

/*
time complexity: O(n)
space complexity: O(1)

*/
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null)return true;
        
        
        //find mid of list
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){ 
            fast = fast.next.next;  // 1 , 2, 3, 2, 1
            slow = slow.next;
        }
        
        //reverse the list from mid.next to end
        ListNode reversed = reverseHelper(slow.next);
        // 1, 2
        
        ListNode ptr1 = reversed;                               // 1, 2, 2, 1
        
    
        //traverse until end of reversed list
        while(ptr1 != null  ){
            if(ptr1. val != head.val){
                return false;
            }
            ptr1 = ptr1.next;
            head = head.next;
        }
        return true;
    }
    
    
    private ListNode reverseHelper(ListNode head){
        // 12 to 2, 1
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = null;
        
        while(curr != null){
            fast = curr.next;   
            curr.next = prev;
            prev = curr;
            curr = fast;
        }
        
        return prev;
    }
}