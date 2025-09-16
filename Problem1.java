// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using post order traversal to get the height and the status of the balanced tree. Checking if the height difference between left and right subtrees is not greater than one at every node.
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedTree(root).isBalanced;
    }

    private Pair isBalancedTree(TreeNode node) {
        // No more nodes
        if (node == null) {
            return new Pair(Integer.MIN_VALUE, true);
        }

        // checking the left and right sub trees
        Pair left = isBalancedTree(node.left);
        Pair right = isBalancedTree(node.right);

        if (!left.isBalanced || !right.isBalanced) {
            return new Pair(Integer.MIN_VALUE, false);
        }

        int rootDepth = Math.abs(left.depth - right.depth);
        if (rootDepth > 1) {
            return new Pair(Integer.MIN_VALUE, false);
        }

        int newDepth = Math.max(left.depth, right.depth);
        return new Pair(1 + newDepth, true);
    }

    record Pair(int depth, boolean isBalanced) {
    }
}