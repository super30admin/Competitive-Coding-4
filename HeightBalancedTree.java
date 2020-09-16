// Time Complexity : O(N) where N is the number of nodes in BT.
// Space Complexity : O(H) where H is height of the BT (for recursive stack).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not really.

public class HeightBalancedTree {
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        int left = checkBalance(root.left, 1);
        int right = checkBalance(root.right, 1);
        
        if(Math.abs(left - right) > 1) {
            return false;
        } else {
            return balanced && true;
        }
    }
    
    private int checkBalance(TreeNode root, int height) {
        if(root == null) {
            return height;
        }
        
        height += 1;
        
        int left = checkBalance(root.left, height);
        int right = checkBalance(root.right, height);
        
        if(Math.abs(left - right) > 1) {
            balanced = false;
        }
        
        return left > right ? left : right;
    }
    
    /* Definition for a binary tree node. */
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
}
