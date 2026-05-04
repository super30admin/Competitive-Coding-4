// Time Complexity :    O(n)
// Space Complexity :   O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// i was thinking from top down approach but it didnt work that way,
// so i switched to bottom up approach, where i check for the leaf nodes and then move up to the root node,
// and check for the height difference at each node, if the difference is greater than 1,
//  then i set the flag to false and return -1 to indicate that the tree is not balanced, 
// otherwise i return the height of the current node which is 1 + max of left and right height.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    boolean flag;

    public boolean isBalanced(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }

    private int helper(TreeNode root) {

        // base
        if (root == null) return 0;

        int left = helper(root.left);
        if (left == -1) return -1;

        int right = helper(root.right);
        if (right == -1) return -1;

        int diff = Math.abs(left - right);

        if (diff > 1) {
            flag = false;
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}