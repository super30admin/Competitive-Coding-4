// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;

        if (getHeight(root) == -1)
			return false;
        int height = getHeight(root);
        System.out.println(height);
		return true;
    }
    
    private int getHeight(TreeNode root){
        if(root==null)return 0;
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        if(left==-1 || right==-1){
            return -1;
        }
        
        if(Math.abs(left-right)>1){
            return -1;
        }
        
        return Math.max(left,right) + 1;
    }
}