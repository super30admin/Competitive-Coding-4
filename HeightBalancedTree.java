// Time Complexity : O(n)
// Space Complexity : O(1)  // recursive stack memory O(n)

public class HeightBalancedTree {
  
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
       if(depth(root)  == -1){
             return false;
       }
       return true;
      
    }

    public int depth(TreeNode node){
         if(node == null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        if(left == -1 || right == -1){
            return -1;
        }
        if(Math.abs(left- right) > 1){
           return -1;
        }
        return Math.max(left, right)+1;
    }
}
