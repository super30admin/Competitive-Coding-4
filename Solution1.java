// Time complexity: O(N), where N is the number of nodes in the linked list.
// Space complexity: O(1)

class Solution1 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
     

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null) {
            ListNode next = curr.next; 
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; 
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true; 
        
        // find the mid of the linkedlist
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // split one list into two lists
        ListNode midHead = slow.next;
        slow.next = null; 
        
        slow = head;
        // reverse the second list
        fast = reverseList(midHead); 
        
        // compare the values of the two lists.
        while(slow!=null && fast!=null) {
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
}
