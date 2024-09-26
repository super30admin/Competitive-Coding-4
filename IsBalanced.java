class IsBalanced{
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        int result = helper(root);
        return isBalanced;
    }

    private int helper(TreeNode root){
        // base
        if(root == null) return 0;
        if(!isBalanced) return 0;


        // logic
        int case1 = helper(root.left);
        int case2 = helper(root.right);
        if(isBalanced && Math.abs(case1 - case2) > 1){
            isBalanced = false;
        }
        return 1+ Math.max(case1, case2);
    }
}