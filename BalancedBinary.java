/*


Time Complexity :  O(n)   here n is the height of the tree.  

 Space Complexity : O(n) recursive stack may contain all the elements of the tree.

*/

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

class Solution {

    public boolean isBalanced(TreeNode root) {
        // base case
        if (root == null)
            return true;

        return Math.abs(helper(root.left) - helper(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper(TreeNode root) {

        if (root == null)
            return -1;
        // checking the depth of the tree.
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}