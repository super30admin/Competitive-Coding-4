// Time Complexity : O(n) — each node visited once
// Space Complexity : O(h) recursion stack (worst-case O(n), best/avg O(log n) for balanced)
// Did this code successfully run on LeetCode : Yes

// approach:
// 1) Post-order DFS that returns subtree height; if unbalanced, return -1.
// 2) For each node, get left/right heights; if either is -1 or |L-R|>1 → return -1.
// 3) Otherwise, return max(L, R) + 1; final answer is (checkHeight(root) != -1).


public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        return checkHeight(root) != -1;
    }

    public int checkHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = checkHeight(root.left);
        if(left == -1) return -1;

        int right = checkHeight(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
