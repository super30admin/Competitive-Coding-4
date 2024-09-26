// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class PalindromLinkedList {
    class Solution {
        public boolean isPalindrome(ListNode head) {

            //create two pointers
            ListNode slow = head;
            ListNode fast = head;

            //loop miving fast pointer @ 2x and slow @1x to get slow to mid point
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            //reverse slow
            slow = reversed(slow);
            fast = head;

            //loop and check if the first half is equal to second half reversed
            while(slow != null){
                if(slow.val != fast.val) return false;

                slow = slow.next;
                fast= fast.next;
            }
            return true;
        }

        //reverse linked list
        public ListNode reversed(ListNode head){
            ListNode prev = null;
            while(head != null){
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}
