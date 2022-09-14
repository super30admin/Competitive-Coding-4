//Time Complexity  O(n)
//Space complexity  O(h)

class Solution {
    boolean result;
    public boolean isBalanced(TreeNode root) {
        result = true;
   height(root);
        return result;
    }
    
    private int height(TreeNode root){
        //base        
        if(root == null) return 0;
        
        //logic
        int left = height(root.left);
        int right = height(root.right);
      
        if(Math.abs(left-right) > 1)result = false;
        
        return 1+ Math.max(left,right);
    }
}
