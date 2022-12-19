
// Time Complexity : O(N) : we will calculate height only ones
// Space Complexity :O(H)
//Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


public class HeightBalancedBinaryTree {
	 
    public boolean isBalanced(TreeNode root) {
        if(root ==null)
            return true;
        
        int result = height(root);   
        
        if(result==-1)
            return false;
        
        else return true;
        
    }
    
    public int height(TreeNode root){
        if(root==null)
            return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        
        
        if(left ==-1 || right ==-1 || Math.abs(left-right) >1)
            return -1;
        
        return Math.max(left,right)+1;      
    }
}
