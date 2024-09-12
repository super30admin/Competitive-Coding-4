package CompetitiveCoding4;

import Trees1.TreeNode;

public class HeightBalancedTree {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }
    private int helper(TreeNode root){
        if(root == null)
            return -1;
        int h1 = 1 + helper(root.left);
        int h2 = 1 + helper(root.right);
        if(Math.abs(h1-h2)>1){
            flag = false;
        }
        return Math.max(h1, h2);
    }
}
