// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :yes


// Your code here along with comments explaining your approach: Used recursion and whenever i get imblanced binary tree i return -1 to the parent

class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightIsBalancedOrNot(root)!=-1;
    }
    private int heightIsBalancedOrNot(TreeNode root){

        if(root==null) return 0;
        
        int leftHeight= heightIsBalancedOrNot(root.left);
        if(leftHeight==-1) return -1;

        int rightHeight= heightIsBalancedOrNot(root.right);
        if(rightHeight==-1) return -1; 

        if(Math.abs(leftHeight-rightHeight)>1) return -1;  
        return Math.max(leftHeight, rightHeight)+1;     
    }
    
}