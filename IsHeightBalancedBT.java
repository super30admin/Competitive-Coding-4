// Time Complexity : O(n)
// Space Complexity : O(h)  ->h is the max height of the tree
// Did this code successfully run on Leetcode : Yes
class TreeNode {
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

public class IsHeightBalancedBT {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    public int helper(TreeNode root)
    {
        if(root == null) return 0;
        int left = 0; int right = 0;
        if(flag)
            left = helper(root.left);

        if(flag)
            right = helper(root.right);

        if(Math.abs(left-right)>1)
        {
            flag = false;
        }
        return Math.max(left,right)+1;
    }
}
