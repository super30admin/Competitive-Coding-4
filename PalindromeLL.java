// Time Complexity: O(N), N = length of the linked list
// Space Complexity: O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return false;
        
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        // reverse list head2
        ListNode prev = null;
        slow = head2;
        while(slow != null) {
            fast = slow.next;
            slow.next = prev;
            prev = slow;
            slow = fast;
        }
        head2 = prev;
        while(head != null && head2 != null) {
            if(head.val != head2.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}
