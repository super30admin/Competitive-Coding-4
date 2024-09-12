/**
 * Time Complexity : O(nlogn) where n = number of nodes in tree
 * Space Complexity : O(n) 
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) 
            return true;
        boolean flag = (Math.abs(helper(root.left) - helper(root.right)) < 2) && isBalanced(root.left) && isBalanced(root.right);
        return flag;
    
    }
    
    public int helper(TreeNode node){
      if (node == null) {
      return -1;
    }
    return 1 + Math.max(helper(node.left), helper(node.right));
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