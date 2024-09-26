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
//Time complexity :O(n);
//Space Complexity : O(height of tree);

class Solution {
    boolean status=true;
    public boolean isBalanced(TreeNode root) {

        if(root==null){
            return true;
        }
        helper(root,0);
        return status;
    }

    public Integer helper(TreeNode node,int height){

        if(node==null){
            return height;
        }

        Integer leftHeight= helper(node.left,height+1);
        Integer rightHeight=helper(node.right,height+1);
        System.out.println("lh = "+leftHeight +"rightHeight = "+rightHeight + "node val. = "+ node.val);
        if(Math.abs(leftHeight-rightHeight)>1){
            status =false;

        }
        return Math.max(leftHeight,rightHeight);
    }
}