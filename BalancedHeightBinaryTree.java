// Time Complexity : O(n) //N being total nodes of Tree
// Space Complexity : O(h) // Height of Tree. These many stacks calls are being stored in worst case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Came up with logic. To codify, it took a lot of time. Condition checks - ufff!

/*
Perform Inorder traversal of Tree
Upon base condition hit, return 0. Then for each node count right and left height.
Take min of them while they return to their node, and add 1 - That is for parent node itself.
At any place, left and right height difference is greater than 1 then mark as false.

*/

public class BalancedHeightBinaryTree {

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

        boolean flag = true;
        public boolean isBalanced(TreeNode root) {
            helper(root); //here the function is returning integer, but main is boolean
            return flag;
        }

        //recursive function
        public int helper(TreeNode root){
            //base
            if(root == null) return 0;

            //logic
            int left = helper(root.left);
            int right = helper(root.right);

            if( Math.abs(left-right) > 1 ) {
                flag = false;
            }
            return Math.max(left, right) + 1; //+1 is for parent node itself when that returns to its parent.
        }
    }