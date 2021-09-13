
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BalancedBinaryTree {

    // TC: O(n) Sc: O(1)
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
        int leftVal = height(root.left);
        int rightVal = height(root.right);
        if (Math.abs(leftVal - rightVal) > 1)
            return -1;
        if (leftVal == -1 || rightVal == -1)
            return -1;
        return Math.max(leftVal, rightVal) + 1;

    }

}

// // TC: O(n) Sc: O(1)
// public boolean isBalanced(TreeNode root) {
// if(root== null) return true;
// int leftVal = height(root.left);
// int rightVal = height(root.right);

// return (Math.abs(leftVal - rightVal)<=1 && isBalanced(root.left) &&
// isBalanced(root.right));
// }

// private int height(TreeNode root){
// //base
// if(root == null) return 0;
// //logic
// return Math.max(height(root.left), height(root.right)) + 1;

// }
