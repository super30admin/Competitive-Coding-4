// Problem 110. Balanced Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    private int helper(TreeNode node){
        //base
        if(node == null){
            return 0;
        }
        int leftHeight = helper(node.left);
        // System.out.println("L: " + leftHeight);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = helper(node.right);
        // System.out.println("R: " + rightHeight);
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
