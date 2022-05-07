// Time Complexity :O(N)
// Space Complexity : O(h)Recursive Stack Space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class BalancedBinaryTree {
    boolean isValid;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        isValid = true;
        int h = dfs(root);
        return isValid;
    }

    public int dfs(TreeNode root){

        //base
        if(root == null){
            return 0;
        }
        //logic
        int left = dfs(root.left);
        int right = dfs(root.right);

        if(Math.abs(left-right) > 1){
            isValid = false;
        }

        return Math.max(left,right)+1;
    }
}
