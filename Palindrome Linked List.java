/*
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head is None or head.next is None:
            return True
        
        slow, fast = head, head
        
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        
        first_list_last_node = slow
        second_list_start = self.reverse_list(slow.next)
        
        first_list_last_node.next = None
        
        self.result = True
        self.checkPalindrome(head, second_list_start)
        
        first_list_last_node.next = self.reverse_list(second_list_start)
        
        return self.result
    
    
    def reverse_list(self, head):
        if head.next is None:
            return head
        
        reversed_head = self.reverse_list(head.next)
        head.next.next = head
        head.next= None
        
        return reversed_head
    
    def checkPalindrome(self, head1, head2):
        if head1 is None or head2 is None:
            return
        
        while head1 != None and head2 != None:
            if head1.val != head2.val:
                self.result = False
            head1 = head1.next
            head2 = head2.next

*/

// Time Complexity : O(n) where n is no of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I reversed the second half of linkedlist and then compared each
// of them by starting from respective heads and again reversed the linkedlist back to original

class Solution {
    boolean flag;
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode slow = head, fast = head;
        
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode first_list_last_node = slow;
        ListNode second_list_start = reverse_list(slow.next);
        first_list_last_node.next = null;
        
        flag = true;
        palindrome(head, second_list_start);
        first_list_last_node.next = reverse_list(second_list_start);
        
        return flag;
        
    }
    
    private ListNode reverse_list(ListNode head){
        if (head.next == null)
            return head;
        
        ListNode reversed_head = reverse_list(head.next);
        head.next.next = head;
        head.next = null;
        
        return reversed_head;
    }
    
    private void palindrome(ListNode head1, ListNode head2){
        while (head1 != null && head2 != null){
            if (head1.val != head2.val){
                flag = false;
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return;
    }
}