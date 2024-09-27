// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Use bottom up recursion, whenever diff btwn left and right heights >1
then return -1
*/
public class HeightBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int result= getHeight(root);
        return result!=-1;
    }

    private int getHeight(TreeNode root){
        if(root==null) return 0;

        int left= getHeight(root.left);
        int right= getHeight(root.right);

        if(Math.abs(left-right)>1 || left==-1 || right==-1) return -1;
        return Math.max(right,left)+1;
    }
}
