// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes		
// Any problem you faced while coding this : yes


// Your code here along with comments explaining your approach



class Solution {
    int Theight = 0;
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
          return true;
        
          if(Math.abs(height(root.left) - height(root.right)) > 1)
              return false;
        
        return isBalanced(root.left) && isBalanced(root.right);

    }
    
    
    private int height(TreeNode root){
     if(root ==  null)
        return -1;
      return 1+ Math.max(height(root.left),height(root.right));
    }
}