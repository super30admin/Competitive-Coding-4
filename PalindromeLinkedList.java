/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        // Step 1 - slow and fast pointer to get the mid of LL
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            slow= slow.next;
            fast = fast.next.next;
        }

        // Step 2 - reversing the second half
        ListNode midPointer = reverse(slow);
        slow = head;
        // Step 3 - compare both until we complete the reversed list traversal
        while(midPointer!=null) {
            if(midPointer.val!=slow.val) {
                return false;
            }
            midPointer = midPointer.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode dummy = null;
        while(node!=null) {
            // maintain a next node to store next address and rechain the existing link to the dummy node which is previous
            ListNode next = node.next;
            node.next = dummy;
            dummy = node;
            node = next;
        }
      //  node.next = dummy;
        return dummy;
    }
}
