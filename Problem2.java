// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
First I caluclate the height of left and right subtree in each iteration.
I calculate if the diff between them is greater than 1.
If it is I set the global flag to false.
*/


import javax.swing.tree.TreeNode;

public class Problem2 {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) {
            flag = false;
            return;
        }

        dfs(root.left);
        if(flag) {
            dfs(root.right);
        }
        
    }

    private int height(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
