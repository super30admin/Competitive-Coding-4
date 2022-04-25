
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BalancedBinaryTree {

    boolean result = true;

    // TC: O(n)  n => number of nodes in a tree
    // SC: O(n)  because we are using the recursion stack
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) return 0;

        // Find out the max depth of the left subtree and the right subtree
        int leftSubTreeMaxDepth = maxDepth(root.left);
        int rightSubTreeMaxDepth = maxDepth(root.right);

        // Find out the difference between these
        if(Math.abs(leftSubTreeMaxDepth - rightSubTreeMaxDepth) > 1)
            result = false;

        // End the current recursion call by returning the max of left depth and right depth
        // Adding 1 because we are returning 0 for the base case
        return 1 + Math.max(leftSubTreeMaxDepth, rightSubTreeMaxDepth);
    }
}
