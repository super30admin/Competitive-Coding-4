/** Given a binary tree, determine if it is height-balanced.
* TC O(N) SC O(H) 
* Follow bottom up approach and keep computing height at every level of left and right subtree
* If at any node the tree is not balanced, retain the result and return the tree as not balanced
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int height = helper(root);
        return (height != -1);
    }
    private int helper(TreeNode root) {
        if (root == null)
        {
            return 0;
        }
        
       int left = helper(root.left);
       int right = helper(root.right);
       if (Math.abs(left-right) > 1 || left == -1 || right == -1 ) {
                return -1;
       }
       return 1 + Math.max(left, right);
    }
}
