// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class PalindromelinkedList {
    class Solution {
        public boolean isPalindrome(ListNode head) {

            if(head == null || head.next == null)
                return true;

            ListNode slow = head, fast = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = reverse(slow.next);
            slow.next = null;

            slow = head;

            while(slow != null && fast != null){
                if(slow.val != fast.val)
                    return false;

                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }
        private ListNode reverse(ListNode head){
            ListNode prev = null, next = null, cur = head;

            while(cur != null){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            return prev;
        }
    }
}
