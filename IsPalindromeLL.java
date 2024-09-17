// TIME: O(n)
// SPACE: O(1)
// SUCCESS on LeetCode

public class IsPalindromeLL {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while (fast != null && slow != null) {
            if (fast.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        slow = reverseList(slow, null);
        fast = head;
        int i = 0;
        while (i < count) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
            i++;
        }
        
        if (slow == null || slow.next == null) return true;
        return false;
    }
    
    private ListNode reverseList(ListNode node, ListNode prev) {
        if (node == null) return prev;
        ListNode temp = node.next;
        node.next = prev;
        return reverseList(temp, node);
    }
}
