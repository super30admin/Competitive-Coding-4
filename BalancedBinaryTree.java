public class BalancedBinaryTree {
    
  //Definition for a binary tree node.
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

  /**
   * Approach 1:    
   *    Find the height at each level of the tree, if any where it is not balanced, return false
   *    Time Complexity: O(n*logn) // since it takes O(n) to calculate the height of the tree, and we need to calculate the height for each level, so for logn levels, it takes n*logn time.
   *    Space Complexity: O(n*logn) // for recursion stack
   */
 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int left =  helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left - right) > 1) 
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int helper(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(1 + helper(root.left), 1 + helper(root.right));
    }
}

/**
 * Approach 2 : Bottom up
 *      while calculating the height of the tree, if anywhere it is not balanced, then return -1
 *      if anywhere we have received -1, then it is not balanced, so return -1 and false at the root level
 * 
 * Time Complexity: O(n) // since we are checking if it is balanced or not while calculating the height itself
 * Space Complexity: O(n) // for the recursion stack
 */
class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(helper(root) == -1)
            return false;
        return true;
    }

    int helper(TreeNode root) {
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left - right) > 1) 
            return -1;
        if(left == -1 || right == -1)
            return -1;
        return Math.max(left, right) + 1;
    }
}

}
