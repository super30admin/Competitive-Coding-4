// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach:

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

public class HeightBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        // base
        if (root == null)
            return 0;

        // logic
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            return -1;
        if (left == -1 || right == -1)
            return -1;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        // Create an instance of the HeightBalancedBinaryTree class
        HeightBalancedBinaryTree heightBalancedBinaryTree = new HeightBalancedBinaryTree();

        // Check if the binary tree is height-balanced
        boolean isBalanced = heightBalancedBinaryTree.isBalanced(root);

        // Output the result
        if (isBalanced) {
            System.out.println("The binary tree is height-balanced.");
        } else {
            System.out.println("The binary tree is not height-balanced.");
        }
    }

}
