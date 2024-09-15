// Time Complexity :O(N) N = no of nodes
// Space Complexity :O(H) H = height
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. We would calculate the height of left and rightsub tree of every node.
//2. To check whether the tree is balanced binary tree or not we can check whether 
//   each node is balanced or not.
//3. Balanced binary tree property is the absolute value of left and right tree's height.

class BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // if(Math.abs(leftHeight - rightHeight) <= 1) return true;
        // else return false;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(leftHeight - rightHeight) <= 1);

    }

    public int findHeight(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return 1;

        int leftPath = findHeight(root.left);
        int rightPath = findHeight(root.right);

        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String args[]) {
        BalancedBinaryTree obj = new BalancedBinaryTree();
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);

        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        System.out.println(obj.isBalanced(tree));
    }
}