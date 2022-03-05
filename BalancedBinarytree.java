// Time Complexity :O(nlogn) //we call height on each node O(logn) times
// Space Complexity :O(n) // recursion takes all nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    
    public int height(TreeNode root){
        if(root == null){
            return -1;
        }
        //return root and max of left and right subtree height
        return 1+Math.max(height(root.left), height(root.right));
        
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;    
        }
        //checking the height condition
        //top down approach
        return Math.abs(height(root.left)-height(root.right)) < 2 && isBalanced(root.left)
            && isBalanced(root.right);
         
        
    }
}