// Time Complexity : O(n)
// Space Complexity : O(1)
public class plaindrome {
   

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = head2;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;
        while(head != null && head2 != null) {
            if(head.val != head2.val) return false;
            else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }
}
}
