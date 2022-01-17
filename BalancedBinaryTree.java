// Time Complexity : O(n) where n is number of node in the binary tree
// Space Complexity : O(h) where h is height of binary tree. in worst case the height of binary tree can be n, so space can be O(n) in that case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class BalancedBinaryTree {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
}
