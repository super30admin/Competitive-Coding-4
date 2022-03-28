// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        // Finding height of left and right subtrees
        int left = helper(root.left); 
        int right = helper(root.right);
        

        //We also need to check that both subtrees are also height - balanced or not
        if(!isBalanced(root.left) || !isBalanced(root.right)){
            return false;
        }
        
        
        //If difference between height is more than 1, tree is not height-balanced. 
        if(Math.abs(left - right) > 1){
            return false;
        }
        
        return true;
        
    }
    public int helper(TreeNode root){
        if(root == null)    return 0;
        
        int leftLen = helper(root.left);
        int rightLen = helper(root.right);
        
        int h = Math.max(leftLen, rightLen);
        
        return h+1;
        
    }
}


public class Prob1_BalancedBinaryTree {
    
}
