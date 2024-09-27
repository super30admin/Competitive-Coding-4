//Problem : 59 - Balanced Binary Tree
// Time Complexity : O(n), n stands for number of nodes
// Space Complexity : O(H), H stands for height of tree in terms of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Questions to be asked at the time of interview:
// is it a BST or binary tree, Data type of node val

// Your code here along with comments explaining your approach
//Just use algo of calculating height of tree. At the time of height calculation for each node, if difference between left height and right height is greater than 1, then just update isBalanced variable to false and return;
class Solution59{
    
    class TreeNode{
         int val;
         TreeNode left,right;
         TreeNode(int val){
             this.val = val;
         }
    }

    private boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        
        if(root==null) return true;
        
        isBalanced  = true;
        
        //for calculating height
        helper(root);
        
        return isBalanced;
    }
    
    private int helper(TreeNode root){
        
        if(root==null) return 0;
        
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        
        if(Math.abs(leftHeight-rightHeight)>1){
            isBalanced = false;
            //return 0;//if tree is not balanced and want to prevent further calculation return from here, but if you want to calculate height, don't return;
        }
        
        return Math.max(leftHeight,rightHeight)+1;
    }
}