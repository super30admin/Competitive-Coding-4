// Time Complexity (TC):
// O(n) – We traverse the list to find the middle, reverse the second half, and compare both halves.

// Space Complexity (SC):
// O(1) – Reversal and comparison are done in-place without using extra data structures.

// Approach:
// Use two pointers (slow and fast) to find the middle of the linked list.
// Reverse the second half of the list and compare it with the first half node by node.
// If all values match, it's a palindrome; otherwise, it's not.

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) slow = slow.next;
        fast = reverse(slow);
        slow = head;
        
        while(fast != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode after = head;
        while(curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
}
