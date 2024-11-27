// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Problem1 {
    boolean flag ;
    public boolean isBalanced(TreeNode root) {
        this.flag = true;
        if(root == null ) return true;
        dfs(root);
        return this.flag;
    }

    //TC:ON
    //SC :O(N)
    public int  dfs (TreeNode root){
        if(root == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        if(flag){
            left = dfs(root.left);
            right = dfs(root.right);
        }

        if(Math.abs(left-right)>1){
            this.flag = false;
        }

        return Math.max(left,right)+1;
    }
}
