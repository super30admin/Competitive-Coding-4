// TC: O(n)
// SC: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        // find middle
        ListNode slow, fast;
        ListNode dummy = new ListNode(-1, head);
        slow = dummy;
        fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse second half
        ListNode first, second, third;
        first = slow.next;
        slow.next = null;
        second = null;
        third = null;
        while(first != null) {
            third = second;
            second = first;
            first = first.next;
            second.next = third;
        }
        // compare
        boolean result = true;
        while(head != null && second != null) {
            if(head.val != second.val) {
                result = false;
                break;
            } else {
                second = second.next;
                head = head.next;
            }
        }
        return result;
    }
}