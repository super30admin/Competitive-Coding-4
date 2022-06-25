// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
        this.right = right;
        this.left = left;
    }

}

class Main {
    public static boolean isBalanced(TreeNode root) {

        // base case
        if (root == null)
            return true;

        // main logic

        // check at each node height of left subtree and right subtress if it is greater
        // than 1 return false;
        if (Math.abs(helper(root.left) - helper(root.right)) > 1) {
            return false;
        }

        // recursion
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public static int helper(TreeNode root) {
        // base case
        if (root == null)
            return 0;
        // logic
        // at each traversal I am tracking max height of each node
        return Math.max(1 + helper(root.left), 1 + helper(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));
    }
}