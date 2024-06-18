// Time Complexity : O(length of linked list)
// Space Complexity : O(1) constant extra space
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Palindrome LinkedList
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
class Sample {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true; // it is palindrome, if its null or just 1 node
        }

        // using slow and fast pointer get to midpoint
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // now slow is at center of the list
        ListNode head2 = slow.next;
        slow.next = null; // break connection

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

    // 1 -> 2 -> 3 -> 4 -> 5
    private ListNode reverse(ListNode node){
        ListNode temp = node.next;
        node.next = null; // reset connection
        ListNode temp2;
        while(temp != null){
            temp2 = temp.next;
            temp.next = node;
            node = temp;
            temp = temp2;
        }
        return node;
    }
}