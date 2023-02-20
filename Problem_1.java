// Time Complexity : O(n) 
// Space Complexity : O(h), where h is height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use a height func which recursively calculates height in a bottom up manner. If any of the subtrees are unbalanced when
   left and right subtree height diff > 1, we return -1 to the parent node. In this way we can keep on returning -1 to parent node
   till we return from height func. Else we return height at that node. In this way we can check height balanced tree.
*/

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
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        return height(root) != -1 ? true : false;

    }

    public int height(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = height(root.left);
        int right = height(root.right);

        if(Math.abs(left - right) > 1)
            return -1;
        
        if(left == -1 || right == -1)
            return -1;
        
        return Math.max(left, right) + 1;
    }
}