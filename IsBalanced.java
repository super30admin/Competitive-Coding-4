/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(h)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        if(height(root)>=100000){
            return false;
        }
        return true;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) >= 2){
            return 100000;
        }
        else{
            return 1 + Math.max(left,right);
        }
    }
}
