// Time Complexity :O(n*n) -> number of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
// 1. Compare the heights of left and rigght subtrees, if difference is greater than 1 return false.
// 2. Else , repeat the above step for both left node of root and right node of root.
public class balancedBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)  return false;
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    public int height(TreeNode root){
        if(root == null)    return 0;
        //if(root.left == null && root.right == null) return 1;
        int left = 1+ height(root.left);
        int right = 1 + height(root.right);
        return Math.max(left,right);
    }
}
