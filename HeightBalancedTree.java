//TC: O(n)
//SC : O(n)

//calculating the height at every node 
//calculating the left and right tree


public class HeightBalancedTree {
 
    class Solution {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode next) { this.val = val;
            }
    }

        public boolean isBalanced(TreeNode root) {
            return height(root) != -1;
        }
    
         private int height(TreeNode root){
    
           if(root == null) return 0;
    
           int left = height(root.left);
    
           int right = height(root.right);
    
           if(Math.abs(left - right) > 1 || 
    
              left == -1 || right == -1) return -1;
    
           return Math.max(left, right) + 1;
    
       }
    }
}
