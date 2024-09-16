// time complexity: o(n);
// space complexity: 0(1);
// idea: By doing a post order traversal on the tree, each root's left and right depth are calculated until all the values of the trees are traversed.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
    maxDepth(root);
    return result;
}

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            result = false;
        return 1 + Math.max(l, r);
    }

    
}