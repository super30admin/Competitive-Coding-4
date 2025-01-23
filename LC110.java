// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree. In the worst case, the height of the tree is O(n)
// where h is the height of the tree and n is the number of nodes in the tree


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
class LC110 {
    boolean ans = true;
    private int recurse(TreeNode root){
        if(root==null) return 0;
        int x = recurse(root.left);
        int y = recurse(root.right);
        int diff = Math.abs(x-y);
        if(diff>=2) ans = false;
        return 1 + Math.max(x, y);
    }
    public boolean isBalanced(TreeNode root) {
        recurse(root);
        return ans;
    }
}