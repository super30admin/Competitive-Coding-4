// Time complexity: O(N), where N is the number of nodes in the tree.
// Space complexity: O(d), where d is the maximum depth of the tree.

class Solution2 {
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

    boolean result = true;

    public int helper(TreeNode root) {
        // base case
        if (root == null)
            return 0;
        
        int leftHeight = helper(root.left); 
        int rightHeight = helper(root.right); 
        if(Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;  
    }
    
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return result;
    }
}