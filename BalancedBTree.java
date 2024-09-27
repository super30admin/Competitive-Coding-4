/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalancedBTree {
    public boolean isBalanced(TreeNode root) 
    {
        return checkBalance(root) != -1;
    }
    
    public int checkBalance(TreeNode node)
    {
        if(node == null)
            return 0;
        
        int leftheight = checkBalance(node.left);
        if(leftheight == -1)
            return -1;
        
        int rightheight = checkBalance(node.right);
        if(rightheight == -1)
            return -1;
        
        if(Math.abs(leftheight - rightheight) > 1)
            return -1;
        
        return Math.max(leftheight,rightheight)+1;
            
        
    }
}






















//     {
//         if(root == null)
//             return true;
        
//         int leftHeight = height(root.left);
//         int rightHeight = height(root.right);
        
//         return (Math.abs(leftHeight - rightHeight) < 2) && isBalanced(root.left) && isBalanced(root.right);
//     }
    
//  public int height(TreeNode node)
//  {
//      if(node == null)
//          return -1;
//      return 1 + Math.max(height(node.left),height(node.right));
//  }
// }