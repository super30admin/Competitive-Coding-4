//Time complexity: O(n)
//Space complexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //find the mid point
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the list
        ListNode head2 = slow.next;
        ListNode prev = null;
        ListNode curr = head2;
        ListNode tmp;
        while(curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        head2 = prev;
        while(head != null && head2 != null) {
            if(head.val != head2.val) {
                return false;
            }
            else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }
}