
public class PalindromLinkList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
//Time Complexity: O(N)
//Space Complexity: O(1)
//Leetcode : Yes


        public boolean isPalindrome(ListNode head) {

            if (head == null) {
                return true;
            }

            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //store the 2nd part of the list in new head and then point the end of the first list to null
            ListNode head2 = slow.next;
            slow.next = null;

            // reverse the list.
            ListNode curr = head2;
            ListNode prev = null, next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            //reset the head2 pointer after reversing the part of the list
            head2 = prev;
            while (head2 != null) {
                if (head.val != head2.val) {
                    return false;
                }
                head = head.next;
                head2 = head2.next;
            }

            return true;

        }
}
