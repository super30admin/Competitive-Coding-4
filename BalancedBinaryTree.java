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
class BalancedBinaryTree {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)
    
    public boolean isBalanced(TreeNode root) {
        // Edge Case Checking
        if(root == null)
            return true;
        int height = dfs(root);

        // If we got an invalid height value (-1) then return false else true
        return height == -1 ? false : true;
    }
    
    private int dfs(TreeNode root){
        // If the node is null - then we return 0 as the height
        if(root == null)
            return 0;
        
        // Calculate the left height for a node
        int leftHeight = dfs(root.left);
        if(leftHeight == -1)
            return -1;
        
        // Calculate the right height for a node
        int rightHeight = dfs(root.right);
        if(rightHeight == -1)
            return -1;

        // If the difference between the height of left and right subtrees differ by more than 1 - then return -1 (invalid case)
        if(Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        // otherwise retur 1 + maximum height between left and right height
        return Math.max(leftHeight, rightHeight) + 1;
    }
}