//Time Complexity : O(n). n is the number of nodes
//Space Complexity : O(h). h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
    boolean res = true;
    public int countheight(TreeNode root){
        if(root==null||res==false){
            return 0;
        }
      int left = countheight(root.left);
        int right = countheight(root.right);
        int height = Math.abs(left-right);
        if(height>1){
            res = false;
        }
        return 1+Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        countheight(root);
        return res;
    }
}