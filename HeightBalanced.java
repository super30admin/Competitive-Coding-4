// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
class HeightBalanced {
    boolean flag = false;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        helper(root);
        return !flag;
    }

    private int helper(TreeNode root){
        if(root == null || flag){
            return 0;
        }

        int left = helper(root.left);
        if(flag){
            return 0;
        }
        int right = helper(root.right);
        if(flag){
            return 0;
        }
        if(Math.abs(left-right) > 1){
            flag = true;
        }
        return 1 + Math.max(left, right);
    }
}
