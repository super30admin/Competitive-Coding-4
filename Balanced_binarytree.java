// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DFS

class Solution {

    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        
        helper(root);

        return flag;
    }

    private int helper(TreeNode root)
    {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int result = (int)Math.abs(left - right);

        if(result > 1) flag = false;

        return 1 + Math.max(left, right);
    }
}