/*
* Time Complexity: O(n)
* 
* Space Complexity: O(h)
    height of the tree because of recursion
* 
*/

public class BalancedBinaryTree {
    private boolean balancedTree = true;

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = helper(root.left);

        int right = helper(root.right);

        if(Math.abs(left-right) >= 2){
            balancedTree = false;
            return 5000;
        }

        return 1 + Integer.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        helper(root);

        return balancedTree;
    }
}
