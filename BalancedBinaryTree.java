// Time Complexity : O(n^2) where n is the number of tree nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//Approach-My approach is to find the height of left subtree and right subtree and calculate the abs difference of it
// if the height is more than 1 the tree is not balanced otherwise initialise a global flag at any situation
// is false the entire tree is unbalanced, and we return the false value;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BalancedBinaryTree {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            height(root);
            if (flag == false) return false;
            inorder(root.right);
        }
        return true;
    }

    public int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            flag = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static class BinaryTree {
        TreeNode root;

        public BinaryTree() {
            this.root = null;
        }

        public void buildSampleTree() {
            root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(5);
            root.left.right = new TreeNode(7);
            root.left.left.left = new TreeNode(6);
            root.left.left.right = new TreeNode(8);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.buildSampleTree();

        BalancedBinaryTree checker = new BalancedBinaryTree();
        boolean result = checker.isBalanced(tree.root);
        System.out.println("Is the binary tree balanced? " + result);
    }
}
