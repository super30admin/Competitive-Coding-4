// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        if(head==null) return true;
        ListNode fast = head;
        ListNode curr2 = head;
        ListNode slow = head;
        ListNode tmp = null;
        ListNode next = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow;
        //next = curr.next;
        while(curr!=null){
            next = curr.next;
            curr.next = tmp;
            tmp = curr;
            curr=next;
        }
        curr = tmp;
        while(curr2!=null && curr!=null && curr.val==curr2.val){
            curr = curr.next;
            curr2 = curr2.next;
        }
        if(curr2!=null && curr!=null && curr.val!=curr2.val)return false;

        return true;
    }
}
