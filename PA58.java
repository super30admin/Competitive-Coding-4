//Leetcode 110. Balanced Binary Tree
//Time complexity: O(n) // n is no of nodes in the tree
//Space Complexity: O(n) // where n is the height of the tree 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        
        int res=helper(root);
        if(res==-1){
            return false;
        }
        return true;
    }
    public int helper(TreeNode root){
       if(root==null){
           return 0;
       }
        
       int lht= helper(root.left);
       int rht= helper(root.right);
        if(lht-rht>1 || rht-lht >1){
            return -1;
        }
        if(lht==-1 || rht==-1){
            return -1;
        }
        return (Math.max(lht,rht)+1);
        
        
        
    }
}