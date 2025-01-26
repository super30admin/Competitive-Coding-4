// Approach: While computing the height of the tree, return -1 if the height of the left or right subtree is -1, or if the balanced
// condition fails at the root. Any height other than -1 indicates that the tree is balanced.
// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/balanced-binary-tree/description/

public class HeightBalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
            left = right = null;
        }
    }

    boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hLeft = height(root.left);
        int hRight = height(root.right);
        if (hLeft == -1 || hRight == -1 || Math.abs(hLeft - hRight) > 1) {
            return -1;
        }
        return 1 + Math.max(hLeft, hRight);
    }

    boolean isBalancedBruteForce(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isBalancedAtRoot = (Math.abs(height(root.left) - height(root.right)) <= 1);
        return isBalancedAtRoot && isBalancedBruteForce(root.left) && isBalancedBruteForce(root.right);
    }

    public static void main(String[] args) {
        HeightBalancedBinaryTree bbt = new HeightBalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
//        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println("Given binary tree is height-balanced (true/false): " + bbt.isBalanced(root));
    }
}