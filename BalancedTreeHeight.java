public class BalancedTreeHeight {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return isHeightBalanced(root) != -1;
    }

    public int isHeightBalanced(TreeNode root){
        if(root == null) return 0;

        int leftSubtreeHeight = isHeightBalanced(root.left);
        if(leftSubtreeHeight == -1) return -1;
        int rightSubtreeHeight = isHeightBalanced(root.right);
        if(rightSubtreeHeight == -1) return -1;

        if(Math.abs(leftSubtreeHeight-rightSubtreeHeight) > 1){
            return -1;
        }

        // return the max heights of the 2 subtrees
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }
}
