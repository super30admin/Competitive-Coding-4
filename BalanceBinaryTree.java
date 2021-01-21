// Time Complexity :O(n)
// Space Complexity :O(h) h is height of the tree worst case h=n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    
    boolean flag = true;
    
    private int depth(TreeNode root)
    {
        //base
        if(root == null) return 0;
        
        // logic
        int L = depth(root.left); // depth of left sub tree
        int R = depth(root.right);  // depth of right sub tree
        
        if(Math.abs(L-R)>1) // check if difference greater than 1
        {
            flag =false;
        }
        
        return Math.max(L,R)+1; // return height 
        
    }
    
    public boolean isBalanced(TreeNode root) {
     
        if(root == null)
            return true;
        
        int height = depth(root);
 
        return flag;
    }
}