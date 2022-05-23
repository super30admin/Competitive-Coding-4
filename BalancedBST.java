/**
 * Traverse using left/right recursion till null, mark that height as 0.
 * Keep adding 1 to height as recursion is returning element from stack/each pop.
 * Compare condition of greater than 1 diff and update result in global.
 * Return result in end
 * <p>
 * TC: O(n)
 * SC: O(h) -> h is height of tree. h will n if it's skewed tree.
 * <p>
 */

class Solution {
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        //base
        if (root == null) {
            return 0;
        }

        //logic

        // int l = helper(root.left);
        // int r = helper(root.right);
        // if(Math.abs(l-r)>1){
        //     result = false;
        // }

        // optimised recursion. Skipping recursion if result is false at any node.
        int l = 0;
        int r = 0;
        if (result) {
            l = helper(root.left);
            r = helper(root.right);
        }
        if (Math.abs(l - r) > 1) {
            result = false;
        }
        return Math.max(l, r) + 1;
    }
}
