/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
        
    }
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int hl = helper(root.left);
        int hr = helper(root.right);
        if(Math.abs(hl-hr) > 1){
            return -1;
        }
        if(hl == -1 || hr == -1) return -1;
        if(hl>hr){
            return hl+1;
        } else {
            return hr+1;
        }
    }
}
// tc o(n)
// sc o(n)
