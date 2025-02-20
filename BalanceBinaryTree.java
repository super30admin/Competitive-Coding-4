// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
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
class Solution {
    boolean result = true;
    private int dfs(TreeNode node)
    {
        if(node == null)
            return -1;
        int left = dfs(node.left);
        int right = dfs(node.right);
        result = result && (Math.abs(left - right) <2);
        return Math.max(left, right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        dfs(root);
        return result;
    }
}
