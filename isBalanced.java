/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity :  O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution{
    public boolean isBalanced(TreeNode root){
         if(root == null){
            return true;
        }
        int lt = height(root.left);
        int rt = height(root.right);
        if(Math.abs(lt - rt) > 1){
            return false;
        } // we return false if the difference between the left subtree and right subtree is greater than 1

        return isBalanced(root.left) && isBalanced(root.right);
    }


    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        return Math.max(left, right);  // return maxo f left and right subtree to get the height of the tree
    }
}