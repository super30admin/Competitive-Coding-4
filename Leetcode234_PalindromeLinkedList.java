//sc;O(1)
//tc: O(n) -3pass ==  pass to find middle,a pass to reverse, a pass to check palindorme
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        slow = reverse(slow);
        fast = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
