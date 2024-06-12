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
  //problem is not finding height difference, it is finding if each subtree has height diff of 1 or less

//TC:O(n) Sc:O(height of tree)
    public boolean isBalanced(TreeNode root) {
        if(root==null )return true;
        if(balancedheight(root)==-1)return false;
        return true;
    }
    int balancedheight(TreeNode root){
        //check if subtree is balanced or not, if not,return -1
        int hleft=0;
        int hright=0;
        if(root==null)return 0;
         hleft=balancedheight(root.left);
        if(hleft==-1)return -1;
        if(hleft!=-1){
         hright=balancedheight(root.right);
        if(hright==-1)return -1;
        if(Math.abs(hleft-hright)>1)return -1;
        }
        return Math.max(hleft,hright)+1;
    }
}
