// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    Recursively find the height for each subTree and compare the left and right subTree.
*/

class Solution {
    
    boolean balanced;
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        balanced = true;
        height(root);
        return balanced;
    }
    
    public int height(TreeNode root){
        if (root.left == null && root.right == null) return 1;
        int leftH = root.left == null ? 0: height(root.left);
        int rightH = root.right == null ? 0 : height(root.right);
        if(Math.abs(leftH-rightH)>1) balanced = false;
        return Math.max(leftH, rightH)+1;
    }
}