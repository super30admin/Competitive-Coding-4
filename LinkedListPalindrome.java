// Time Complexity : O(N) since we are linearly traversing the linked list every time.
// Space Complexity : O(1) as we are just using pointers.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not really.

public class LinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = reverseList(slow.next);
        
        ListNode head1 = head;
        
        while(head1 != null && head2 != null) {
            if(head1.val != head2.val) {
                return false;
            }
            
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
    }
    
    public ListNode reverseList(ListNode head) {        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode previous = head;
        ListNode auxillary = head.next;
        
        while(auxillary != null) {
            ListNode temp = auxillary.next;
            previous.next = temp;
            auxillary.next = head;
            head = auxillary;
            
            auxillary = temp;
        }
        
        return head;
    }

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
