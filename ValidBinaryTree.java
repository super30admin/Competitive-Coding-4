/**
Time Complexity : exponential
Space Complexity : O(D) D = depth of the binary Tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
 */
class Solution 
{
    boolean isBalanced = true;
    
    public boolean isBalanced(TreeNode root) 
    {
        if(root == null || (root.left ==null && root.right ==null))
            return isBalanced;
        
        preorder(root);
        
        return isBalanced;
    }
    
    public void preorder(TreeNode root)
    {        
        int leftHeight = 0;
        int rightHeight = 0;
        
        if(root.left !=null)
            leftHeight = height(root.left);
        
        if(root.right != null)
            rightHeight = height(root.right);
        
        if(Math.abs(leftHeight-rightHeight) > 1)
        {
            isBalanced = false;
            return;
        }
        
        if(root.left !=null)
            preorder(root.left);
        
        if(root.right != null)
            preorder(root.right);
        
    }
    
    private int height(TreeNode root)
    {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return 1;
        
        int left = 0;
        int right = 0;
        
        if(root.left != null)
            left = height(root.left);
        
        if(root.right != null)
            right = height(root.right);
        
        return 1 + Math.max(left, right);
            
    }
}