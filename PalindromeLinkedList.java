// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Find the mid of the linked list with the help of a slow and fast pointer, reverse the linked list starting from the mid + 1, and iterate through the two lists to check if the values are same, to determine if its a palindrome.
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        slow = head;
        
        ListNode prev = null;
        ListNode curr = fast;
        ListNode next;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        fast = prev;
        
        while(fast != null){
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
}
