


class BTreeHeightBalanced {

  // Time Complexity : O(N)
  // Space Complexity : O(h) - h being height of a tree (Considering recursive stack space)
  // Did this code successfully run on Leetcode : YES
  // Any problem you faced while coding this : NO
  // Approach : at each node check if it is balanced or not 

    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        helper(root, 0);
        return isBalanced;
    }

    private int helper(TreeNode root, int height){
        if(root == null) return height;
        int leftHeight = helper(root.left, height+1);
        int rightHeight = helper(root.right, height+1);

        if(Math.abs(leftHeight - rightHeight) > 1){
            isBalanced = false;
        }
        return Math.max(leftHeight,rightHeight);
    }

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

  }
