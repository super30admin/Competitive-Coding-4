// Time Complexity : O(n) where n is the number of nodes in the linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
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
        int count = 0;

        ListNode fast = head;
        ListNode tail = head;
        ListNode slow = head;
       while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        slow.next = reverseLinkedList(slow.next);

        tail = slow.next;
       int temp = 0;


        while(temp != count+1 && tail != null && head != null){
            if(head.val != tail.val)
                return false;
            head = head.next;
            tail = tail.next;
            temp++;
        }

        return true;
    }

    private ListNode reverseLinkedList(ListNode start){
        ListNode temp = start;
        ListNode prev = null;

        while(temp != null){
            temp = start.next;
            start.next = prev;
            prev = start;
            start = temp;
        }

        return prev;
    }


}
