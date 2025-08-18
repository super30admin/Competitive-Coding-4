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

 // This solution focuses on checking the height difference between the children nodes at each node and at each level. If it is -1, it implies that some children tree is unbalanced. If not we check the height difference between both the child nodes and return -1 if it is greater than 1 other wise -1
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeightDifference(root)!=-1;
    }

    private int checkHeightDifference(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) { return 0;}

        int left = checkHeightDifference(root.left);

        if(left == -1) return -1;
        
        int right = checkHeightDifference(root.right);

       if(right==-1) return -1;

        if(Math.abs(left-right)>1) return -1;
        return 1+Math.max(left,right);
    }
}
