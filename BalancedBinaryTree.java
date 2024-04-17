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
    // TC -> O(N), N is the number of nodes
    // SC -> O(H), where H is the height of the tree
    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        if(Math.abs(height(root.left) - height(root.right)) > 1)
            return false;
        else return isBalanced(root.right) && isBalanced(root.left);
        
    }

    public int height(TreeNode root){
        if (root == null)
            return 0; // -1 or 0. Ideally it should be -1, since height for the leaf nodes are actually 0, and below them , the null nodes should have an height of -1
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
