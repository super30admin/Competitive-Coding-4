// Problem 1 - Palindrome Linked List
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Algorithm
// 1 - initiliaze 2 pointers
// 2 - get the mid node
// 3 - reverse the linked list from head to mid
// 4 - keep comparing reversed linked list with 2nd half node by node
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
    if (head == null || head.next == null) {
        return true;
    }
    // 1
    ListNode p1 = head;
    ListNode p2 = head;
    // 2
    while (p2 != null && p2.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }
    // 3
    ListNode temp = null;
    ListNode prev = null;
    ListNode curr = head;
    while (curr != p1) {
      temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }

    if (p2 != null && p2.next == null) {
      p1 = p1.next;
    }
    // 4
    while (p1 != null) {
      if (p1.val != prev.val) {
        return false;
      }
      p1 = p1.next;
      prev = prev.next;
    }

    return true;
  }
}

// Problem 1 - Balanced Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(n) -> recersive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    // 1
    int heightLeft = height(root.left);
    // 2
    int heightRight = height(root.right);
    
    // 4
    if (isBalanced(root.left) && isBalanced(root.right) && Math.abs(heightLeft - heightRight) < 2) {
      return true;
    }
    return false;
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // 3
    return Math.max(height(root.left), height(root.right)) + 1;
  }    
}
