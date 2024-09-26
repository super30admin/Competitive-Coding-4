/**
 * Definition for a binary tree node.
 */ public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 /*Approach
 1) start with bottom up approach
 2) check for balanced conditions
 3) we add 1 as we consider the root node afterwards 
 4) as recursion will go down and calculate the heights from downward to upwards
 5) if the node is null, we return true (as nothing to balance, already balanced, base condition to stop recursion)
 calculating heights as diff <=1
 left of whole left subtree and whole right subtree
 for every subtree take the max of left and right subtrees+1
 
 */
class Solution {
    
    
    public boolean isBalanced(TreeNode root) {
    
        if(root==null)
            return true;
        
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right))<=1;
                 
        
    }
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        
        
        return Math.max(height(root.left),height(root.right))+1;
        
    }
    
   
}