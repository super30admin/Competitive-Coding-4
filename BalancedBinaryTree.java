// Time Complexity :    O(n)
// Space Complexity :   O(h) //height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Definition for a binary tree node.
class TreeNode {
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

class BalancedBinaryTree {
    private int height(TreeNode root){
        if (root == null)   return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null)   return true;
        
        if(Math.abs(height(root.left) - height(root.right)) > 1){
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
}