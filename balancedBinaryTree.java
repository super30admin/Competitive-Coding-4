// Time Complexity :O(n)
// Space Complexity :O(n) n-recursive stack
// Did this code successfully run on Leetcode :yes 
class Solution {
    Boolean balanced=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        helper(root,0);
        return balanced;
    }
    private int helper(TreeNode root,int height)
    {
        if(root==null) return height;
        int h1=helper(root.left,1+height);
        int h2=helper(root.right,1+height);
        if(Math.abs(h2-h1)>1) balanced=false;
        
        return Math.max(h1,h2);
       
    }
}
/*
class Solution {
    public boolean isBalanced(TreeNode root) {
		//base case
        if(root==null) return true;  
		
        int h1=helper(root.left,1); // pass 1 for height because we are starting with the subtree not the root
        int h2=helper(root.right,1);
        if(Math.abs(h2-h1)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int helper(TreeNode root,int height)
    {
	    //base case
        if(root==null) return height; 
		
        return Math.max(helper(root.left,height+1), helper(root.right,height+1));    // return max as maximum length is the height
    }
}
*/