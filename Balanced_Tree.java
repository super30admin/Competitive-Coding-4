// Time Complexity : O(n)
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using recursion check the height of left and right subtree untill the left and right becomes null
//If the values of left and right nodes are different then it is not balanced Binary tree
//to a parent node return the maximum height of left and right child 
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
    boolean toReturn = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dfs(root);
        return toReturn;
        
    }

    private int dfs(TreeNode root) {
        //base
        if (root == null) return 0;
        //logic
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) {
            toReturn = false;
            return -1;
        }

        //height of each subtree to its parent node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
