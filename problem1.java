public class problem1 {
// Time Complexity : O(n^2) in the worst case, where n is the number of nodes in the tree.
// This is because, for each node, we calculate the height of its left and right subtrees,
// which takes O(n) time, and this process is repeated for all n nodes.

// Space Complexity : O(n), where n is the height of the tree. The space complexity is
// determined by the call stack used by the recursive function calls.

// Did this code successfully run on Leetcode : Yes

    //  Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public boolean isBalanced(TreeNode root) {

            if(root==null)
            {
                return true;
            }

            return (Math.abs(height(root.left) - height(root.right)) <=1 &&
                    isBalanced(root.left) && isBalanced(root.right));
        }
        int height(TreeNode node)
        {
            if(node==null)
            {return 0;}
            return 1+ Math.max(height(node.left) , height(node.right));
        }
    }

}
