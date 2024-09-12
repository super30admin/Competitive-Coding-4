// Time Complexity : O(N) as i will be visiting each node once
// Space Complexity : O(N) for the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class Solution {
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        
        depth(root);
        return ans;
    }
    
    public int depth(TreeNode node) {
        
        if(node == null)
            return 0;
        
        int L = depth(node.left);
        int R = depth(node.right);
        
        if(Math.abs(L - R) > 1)
            ans = false;        
        
        return Math.max(L, R) + 1;        
    }
    
}