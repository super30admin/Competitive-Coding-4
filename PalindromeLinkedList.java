// Time Complexity : O(n) where n is length of the linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I faced problem in finding position of the list node where my second half of linked list should start

public class PalindromeLinkedList{
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        //find the middle
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reverse the second half
        ListNode prev = null, curr = slow;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        //prev will point to the head of the reversed linked list
        
        //check for palindrome
        fast = head;
        
        while(prev != null && fast != null){
            if(prev.val != fast.val){
                return false;
            }
            prev = prev.next;
            fast = fast.next;
        }
        
        return true;
    }

    public class ListNode {
            int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
}