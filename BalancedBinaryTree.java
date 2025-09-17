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

/*  Each node in the recursion tree represents a call to height(node).
	Leaf nodes (null) immediately return 0.
	Internal nodes calculate:
	left = 1 + height(left child)
	right = 1 + height(right child)
	Update flag if difference > 1
	Return Math.max(left, right)
*/

//TC: O(n) => iterate through all the nodes
// SC:O(h) => recursive stack with at most h nodes -> height of the tree and worst case - TC:O(n) -> skewed tree
class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.flag = true;
        if(root == null)
            return true;
        int maxHeight = height(root);
        return flag;
    }

    private int height(TreeNode root){
        //base
        if(root == null)
            return 0;
        //logic
        int left = 1 + height(root.left);
        int right = 1 + height(root.right);

        if(Math.abs(left - right) > 1)
            flag = false;
        return Math.max(left, right);
    }
}

