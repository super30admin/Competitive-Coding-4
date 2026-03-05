// TimeComplexity: O(n) where n is number of nodes
 // SpaceComplexity: O(h) where h is height of the tree
class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return flag;
        
    }

    private int helper(TreeNode root) {
        // base
        if(root == null) return 0;

        //logic
        int left = 1 + helper(root.left);

        int right = 1 + helper(root.right);

        if(Math.abs(left-right) > 1) {
            flag = false;
        }

        return Math.max(left,right);

    
    }
    
}