
// Time Complexity : O(n), where n is the number of nodes (each node visited once).
// Space Complexity : O(h), where h is the tree height due to recursion stack (O(log n) for balanced, O(n) worst-case).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// - Use a post-order traversal helper that returns the height of a subtree.
// - If any subtree is unbalanced, return -1 as a sentinel to bubble up early.
// - A node is unbalanced if |leftHeight - rightHeight| > 1.
// - Overall tree is balanced iff helper(root) != -1.

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    // Returns height if balanced; otherwise returns -1.
    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        if (left == -1) return -1; // Left subtree unbalanced

        int right = helper(root.right);
        if (right == -1) return -1; // Right subtree unbalanced

        if (Math.abs(left - right) > 1) return -1; // Current node unbalanced

        return Math.max(left, right) + 1; // Height of current subtree
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        // Example 1: Balanced tree
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        // Example 2: Unbalanced tree
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.left.left = new TreeNode(3);
        t2.left.left.left = new TreeNode(4);

        BalancedBinaryTree sol = new BalancedBinaryTree();
        System.out.println("Is example 1 balanced? " + sol.isBalanced(t1)); // true
        System.out.println("Is example 2 balanced? " + sol.isBalanced(t2)); // false
    }
}

// Definition for a binary tree node.
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
