class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int lh = 0;
        int lr = 0;
        if(root==null)
        {
            return true;
        }
        lh = height(root.left);
        lr = height(root.right);

        if(Math.abs(lh-lr) <=1 && isBalanced(root.left) && isBalanced(root.right))
        {
            return true;
        }
        else
            return false;
    }
    private int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int m = 1 + Math.max(height(root.left),height(root.right));
        return m;
    }
}

//Time complexity is O(n)
//Space complexity is O(h). h is the height.