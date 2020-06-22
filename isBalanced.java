// Time Complexity :O(n) n is the number of nodes in the tree
// Space Complexity :O(h) h is the height of the recursive stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    
    public boolean isBalanced(TreeNode root) {
        
        if(root == null||( root.right==null && root.left ==null)) return true;
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int helper(TreeNode node){
        
        
        if(node == null) return 0;
        return (1+Math.max(helper(node.left), helper(node.right)));
    }
}