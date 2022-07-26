// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftMax=getMaxDepth(root.left);
        int rightMax=getMaxDepth(root.right);
        if(Math.abs(leftMax-rightMax)>1){
            return false;
        }
        boolean leftres=isBalanced(root.left);
        boolean rightres=isBalanced(root.right);
        return leftres && rightres;
    }
    private int getMaxDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=getMaxDepth(node.left);
        int right=getMaxDepth(node.right);
        return Math.max(left,right)+1;
    }
}