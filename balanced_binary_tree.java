// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(n) , space occupied by recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//-> Recursive Approach  - Top down approach
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        
        //check for height of left and right subtree at each node and proceed further down if condition of difference not greater than 1 satisfies.
        return (Math.abs(height(root.left) - height(root.right))<=1) && isBalanced(root.left) && isBalanced(root.right);
        
    }
    
  //code for checking height of a node
    private int height(TreeNode root){
        if(root==null) return -1;
        
        int left=0;
        int right=0;
        
        if(root.left!=null){
            left=1+height(root.left);//height of left subtree
        }
        
        if(root.right!=null){
            right=1+height(root.right);//height of right subtree
        }
        
        return Math.max(left,right);//maximum height of a node 
    }
}
