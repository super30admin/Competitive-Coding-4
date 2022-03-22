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
class Solution {
 
    HashMap<TreeNode, Integer> cache = new HashMap<>();
    
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        
        int leftheight = helper(root.left);
        int rightheight = helper(root.right);
        
        return Math.abs(leftheight - rightheight)<=1 && isBalanced(root.left) && isBalanced(root.right);

    }
    
    private int helper(TreeNode root){
        //if(root.left== null && root.right== null) 
        if(root== null)
            return 0;
        if(cache.containsKey(root)) {
            return cache.get(root);
        }
        
       int result = 1+ Math.max( helper(root.left), helper(root.right));
         cache.put(root, result);
        return result;
        
        
    }
}
//Time complexity- O(n)
//space- O(n)