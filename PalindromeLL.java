// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
//Approach : Find mid, reverse second half and check if it is a palindrome.


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
    ListNode front;
    public boolean isPalindrome(ListNode head) {
        front = head;
        return helper(head);
    }

    private boolean helper(ListNode curr){
        if(curr != null){
            if(!helper(curr.next)) return false;
            if( curr.val != front.val) return false;
            front = front.next;
        }

        return true;
    }
}