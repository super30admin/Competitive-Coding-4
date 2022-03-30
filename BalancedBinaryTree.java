/**
 * Time complexity is O(n) 
 * space complexity is O(n)
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int l = height(root.left);
        int r = height(root.right);
        
        if(l == -1 || r == -1 || Math.abs(l-r) > 1) {
            return -1;
        }
        
        return 1 + Math.max(l, r);
    }
    class TreeNode {
        TreeNode left;
        TreeNode right;
    }
}