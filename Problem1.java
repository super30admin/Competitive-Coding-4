// Time Complexity : O(N)
// Space Complexity : O(N)
//Leetcode problem: https://leetcode.com/problems/palindrome-linked-list/


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
class Problem1 {

    boolean flag;
    ListNode front;
    public boolean isPalindrome(ListNode head) {

        front = head;
        flag = true;
        helper(head);
        return flag;
    }

    void helper(ListNode curr){

        if(curr == null) return;

        helper(curr.next);

        if(front.val != curr.val){
            flag = false;
        }

        front = front.next;

    }

}