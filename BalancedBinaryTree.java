/**
 * Leetcode 110. Balanced Binary Tree
 * Link: https://leetcode.com/problems/balanced-binary-tree/description/
 */
public class BalancedBinaryTree {
    /**
     * Use bottom-up approach using postorder traversal to check if left and right subtrees are height-balanced (diff =< 1)
     * Using an int based recursive call either return -1 to mark that the left and right subtrees are not balanced at current node
     * or return actual depth at the node to its parent node. Add conditional recursion by checking left depth is -1 or right depth is -1
     *
     * TC: O(n) Auxiliary SC: O(1)
     * Recursive stack SC: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    public boolean isBalanced(TreeNode root) {
        int result = dfs(root);
        return result != -1;
    }

    private int dfs(TreeNode root) {
        //base
        if (root == null) {
            return 0;
        }

        //logic
        int left = dfs(root.left);
        if (left == -1) { //early return if left subtree is not h-balanced
            return -1;
        }

        int right = dfs(root.right);
        if (right == -1) { //early return if right subtree is not h-balanced
            return -1;
        }

        if (Math.abs(left - right) > 1) { //return -1 if left and right subtrees are not h-balanced
            return -1;
        } else {
            return Math.max(left, right) + 1; //return actual maxdepth of the node/root
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
