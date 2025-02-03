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

// TC: O(1), No extra space has been used
// SC: O(h) where h is the height of the recursion stack for the tree node
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root)); // true

        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(root1)); // false
    }

    // Global variable for status
    static boolean status;

    public static boolean isBalanced(TreeNode root) {
        status = true;
        get(root);
        return status;
    }

    private static int get(TreeNode root) {
        // Base conditions
        if (root == null)
            return 0;
        if (!status)
            return 0;

        // Recursion call for going down the tree
        int left = get(root.left);
        int right = get(root.right);
        if (Math.abs(left - right) > 1)
            status = false;
        // returns the max height
        return 1 + Math.max(left, right);
    }

}