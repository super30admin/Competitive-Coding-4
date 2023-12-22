//T.C O(n)
//S.C O(1)
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
//Recursively calculate the height of sub trees and return -1 if any of left or right subtrees are not balanced, otherwise return height.
//The tree is balanced when none of the sub trees height return -1.
class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int res = height(root);
        return res!=-1;
    }

    private int height(TreeNode root){
        //base
        if(root == null) return 0;
        //logic
        int left= height(root.left);
        int right=height(root.right);

        if(Math.abs(left - right)>1) return -1;
        if(left== -1|| right == -1) return -1;

        return Math.max(left, right) +1;
    }
}