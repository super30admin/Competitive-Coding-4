// Time Complexity :o(n) where n is number of nodes
// Space Complexity : o(n) where n is number of nodes (use of implicit stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : differnce in height of leftsubtree and right subtree should not be more than 1 


// Your code here along with comments explaining your approach :
class Solution {
    public boolean isBalanced(TreeNode root) {
      int height = getHeightOfTree(root);
      return height != -1;
    }

    public int getHeightOfTree(TreeNode root){

        if(root == null) return 0;

        int left = getHeightOfTree(root.left);
        int right = getHeightOfTree(root.right);

        if(left == -1 || right  == -1 || Math.abs(right - left) > 1) return -1;

        return Math.max(left, right) + 1;

    }
}
