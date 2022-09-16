// TC - O(n)
// SC - O(1)

public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {

        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null) return true;
            ListNode slow = head;
            ListNode fast = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode head2 = slow.next;
            slow.next = null;

            head2 = reverse(head2);
            while(head != null && head2 != null) {
                if(head.val != head2.val){
                    return false;
                }

                head = head.next;
                head2 = head2.next;
            }
            return true;
        }

        private ListNode reverse (ListNode head) {
            if(head == null || head.next == null) return head;

            ListNode prev = null;
            ListNode curr = head;
            ListNode last = head.next;

            while(last != null) {
                curr.next = prev;
                prev = curr;
                curr = last;
                last = last.next;
            }
            curr.next = prev;

            return curr;
        }
    }
}
