//Time Complexity: O(n)
//Space Complexity: O(h) amortized, O(n) worst case
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return false;
        return dfs(root, 0) != -1;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) return depth;

        depth += 1;
        if (root.left == null && root.right == null) return depth;

        int left = dfs(root.left, depth);
        int right = dfs(root.right, depth);

        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        final BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(balancedBinaryTree.isBalanced(root)); //return true
        System.out.println(balancedBinaryTree.isBalanced(null)); //return false

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(3), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        System.out.println(balancedBinaryTree.isBalanced(root)); //return false
    }
}
