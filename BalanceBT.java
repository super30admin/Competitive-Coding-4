// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        
        return Math.abs(height(root.left) - height(root.right))<2 &&
            isBalanced(root.left) &&
            isBalanced(root.right);
    }
    
    private int height(TreeNode root){
        if(root==null){
            return -1;
        }
        return 1 + Math.max(height(root.left) , height(root.right));
    }
}