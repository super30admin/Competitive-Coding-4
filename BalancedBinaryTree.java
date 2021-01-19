// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up with the recursive case

// Notes : Recurse to the left subtree and then the right subtree and check if the root is balanced at each node. 

public class BalancedBinaryTree {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int valid = helper(root);
        return flag;
    }
    
    private int helper(TreeNode root){
        if(root == null)
            return -1;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int diff = Math.abs(left - right);
        
        if(diff > 1){
            flag = false;
        }
        
        return Math.max(left, right) + 1;
    }
}
