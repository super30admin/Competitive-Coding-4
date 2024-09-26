package com.ds.rani.linkedlist;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

//Approach: I am using fast and slow runner, when fast runner reaches at end my slow runner will be at mid.
// while coming to mid i am pushing slow runner elements to stack.
//now i will continue traversing with slow runner and comparing stack elements with rest of the elements.

//Time Complexity:o(n)
//Space complexity:o(n) in worst case
public class PalindromeLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push( slow.val );
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.val)
                return false;
            slow = slow.next;
        }
        return true;


    }

    /******************Recursive solution***************************************/
    //Time complexity:o(n)
    //space complexity:o(1) not considering stack space
    ListNode curr;
    public boolean isPalindromeRecursive(ListNode head) {
        curr = head;
        return helper(head);
    }

    public boolean helper(ListNode node){
        //base case
        if(node == null)
            return true;

        //recursive call
        boolean ans = helper(node.next);

        //logic
        boolean isEqual = (curr.val == node.val)? true : false;
        curr = curr.next;
        return ans && isEqual;
    }
}
