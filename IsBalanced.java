// Time Complexity : O(n)
// Space Complexity :O(1)

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
          if(getHeight(root) > -1)
              return true;
           else 
            return false;  
   }
   //get the height : max height of left and right sub trees
   
   private int getHeight(TreeNode root){
       if(root == null) return 0;
      
       
       int left = getHeight(root.left);
       int right = getHeight(root.right);
       
       if(left == -1) return -1;
       if(right == -1) return -1;
       if (Math.abs(left - right) > 1) return -1;
       
       return Math.max(left, right) + 1;
   }
}
