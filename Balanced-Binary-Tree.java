110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced
Input: root = [3,9,20,null,null,15,7]
Output: true


Time Complexity :O(n)
space Complexity : O(h)
Approach :We will recursively go and do a inorder traversal and calculate the height
class Solution {
    public boolean isBalanced(TreeNode root) {
        //base condition
        if(root==null){
            return true;
        }
        //called the heightEqual function
        int height = heightEqual(root);
        if(height==-1){
            return false;
        }
        return true;
    }
    private int heightEqual(TreeNode root){
        //base case condition
        if(root==null){
            return 0;
        }
        
       // Left sub tree call
       int heightLeft= heightEqual(root.left);
       
       if(heightLeft == -1){
        return -1;
       }
        // Right sub tree call 
        int heightRight = heightEqual(root.right);
        if(heightRight == -1){
        return -1;
       }
        if( Math.abs(heightRight-heightLeft)>1){
            return -1;
        }
        return Math.max(heightRight,heightLeft)+1;
    }
}