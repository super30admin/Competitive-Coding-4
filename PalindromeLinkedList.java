// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// First find out the middle element in the list
// reverse the other half of the list
// Iterate both the list to check if it is palinrodme or not

public class PalindromeLinkedList {

    public static void main(String args[]) {
        ListNode head = new ListNode();
        head.val = 0;
        head.next = new ListNode(0);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome(new ListNode()));
    }
    public static boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head.next;
        if(head.next == null) return true;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        
        ListNode prev = null;
        ListNode curr = head2;
        fast = head2.next;
        
         while(fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;  
        }
        curr.next = prev;
        head2 = curr;
        while(head != null && head2 != null) {
            if(head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        
        return true;
        
    }
    
}

class ListNode {
        int val;
        ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
