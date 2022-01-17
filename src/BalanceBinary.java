// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class BalanceBinary {
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
        boolean flag = true;
        public boolean isBalanced(TreeNode root) {
            if(root == null) {
                return true;
            }
            int height = getHeight(root);
            return flag;
        }
        private int getHeight(TreeNode root) {
            //base
            int height = 0;
            if(flag == false) {
                return 0;
            }
            if(root.left==null && root.right==null) {
                return 1;
            }
            //logic
            if(root.left!=null && root.right!=null) {
                int heightLeft = getHeight(root.left);
                int heightRight = getHeight(root.right);
                height = Math.max(heightLeft, heightRight) + 1;
                int balance = Math.abs(heightLeft - heightRight);
                if(balance > 1) {
                    flag = false;
                }
            } else if(root.left==null) {
                int heightRight = getHeight(root.right);
                height =  heightRight + 1;
                int balance = Math.abs(0 - heightRight);
                if(balance > 1) {
                    flag = false;
                }
            } else {
                int heightLeft = getHeight(root.left);
                height =  heightLeft + 1;
                int balance = Math.abs(0 - heightLeft);
                if(balance > 1) {
                    flag = false;
                }
            }
            return height;
        }
    }
}
