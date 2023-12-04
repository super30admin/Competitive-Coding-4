// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class IsBalancedTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(helper(root.left) - helper(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 1 + helper(root.left);
        int right = 1 + helper(root.right);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        //root.left.left.left = new TreeNode(4);
        //root.left.left.right = new TreeNode(4);

        // Creating an instance of Solution
        IsBalancedTree solution = new IsBalancedTree();

        // Checking if the binary tree is balanced
        boolean isBalanced = solution.isBalanced(root);

        // Printing the result
        System.out.println("Is Balanced: " + isBalanced);
    }
}
