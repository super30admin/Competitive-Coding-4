// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Problem1 {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {

        //if root is null
        if(root == null) return true;

        height(root);

        return flag;

    }

    private int height(TreeNode root){

        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        int h = Math.max(left,right) +1;

        if(Math.abs(left-right) > 1)
            flag = false;


        return h;
    }
}