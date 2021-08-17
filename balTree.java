// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    private int height(TreeNode root) {
      if (root == null) {
        return -1;
      }
      return 1 + Math.max(height(root.left), height(root.right));
    }
  
    public boolean isBalanced(TreeNode root) {
      if (root == null) {
        return true;
      }
      return Math.abs(height(root.left) - height(root.right)) < 2
          && isBalanced(root.left)
          && isBalanced(root.right);
    }
  };