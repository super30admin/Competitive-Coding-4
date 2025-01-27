// Time Complexity : O(n)
// Space Complexity : O(h)
class HeightBalancedBinaryTree {
    boolean isHeightBalanced;
    public boolean isBalanced(TreeNode root) {
        if(root==null || (root.left==null && root.right == null)){
            return true;
        }
        isHeightBalanced = true;
        isBalancedRecursive(root);
        return isHeightBalanced;
    }

    private int isBalancedRecursive(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int case1 = isBalancedRecursive(root.left) + 1;
        int case2 = isBalancedRecursive(root.right) + 1;

        if(Math.abs(case1-case2)>1){
            isHeightBalanced = false;
        }

        return Math.max(case1, case2);
    }
}