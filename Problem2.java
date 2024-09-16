// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
cut the list in half, reverse second half & check nodes for palindrome

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
        if(head==null)
            return true;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = slow.next;
        reverse = reverseNode(reverse);

        while(reverse!=null){
            if(head.val!=reverse.val)
                return false;
            reverse = reverse.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverseNode(ListNode start){
        ListNode reverse = null; //1-2-null
        while(start!=null){ //2-1-null
            ListNode temp = start.next;
            start.next = reverse;
            reverse = start;
            start = temp;
        }

        return reverse;
    }
}