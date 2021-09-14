// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l - r) > 1)
            result = false;
        return 1 + Math.max(l, r);
    }
}