 //reverse the second half of the list and then compare heads to check if palindrome or not
 //Time complexity: O(n)
 //Space complexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        slow.next = null;
        ListNode first = head;
        ListNode second = prev;
        while(second != null) {
            if(first.val != second.val) return false;
            first = first.next;
            second= second.next;
        }

        return true;

    }
}