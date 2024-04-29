import javax.swing.tree.TreeNode;

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
// Time Complexity :Nlog(N) , O(n) at each level of the tree
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
/*class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        //base case
        if(root == null) return true;
        //logic
        //checking if the diff between height of left subtree and right subtree is greater than 1
        if(Math.abs(height(root.left) - height(root.right)) > 1) return false;
        //else the node is balanced and we are recursively checking if left subtree and right subtree are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode root) {
        //base case
        if(root == null) return 0;
        //logic
        //finding the height of the node
        return Math.max(height(root.left), height(root.right))+1;
    }
}*/
// Time Complexity :O(N), N is the no of nodes in the tree
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        //base case
        if(root == null) return true;
        //logic
        return height(root) != -1;
    }
    private int height(TreeNode root) {
        //base case
        if(root == null) return 0;
        //logic
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        if(leftHeight == -1 || rightHeight == -1) return -1;
        //finding the height of the node
        return Math.max(leftHeight, rightHeight)+1;
    }
}