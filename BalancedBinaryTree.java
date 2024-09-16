// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH 1
 Starting from the bottom nodes, check the height difference between the left and right subtrees.
*/

public class BalancedBinaryTree {

    public static class TreeNode {
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
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int left = height(root.left);
        int right = height(root.right);

        if(Math.abs(left - right) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        if(Math.abs(left - right) > 1 || left == -1 || right == -1){
            return -1;
        }

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args){
        TreeNode leaf1 = new TreeNode(9, null, null);
        TreeNode leaf2 = new TreeNode(15, null, null);
        TreeNode leaf3 = new TreeNode(7, null, null);
        TreeNode mid1 = new TreeNode(20, leaf2, leaf3);
        TreeNode root = new TreeNode(3, leaf1, mid1);
        System.out.println(isBalanced(root)); //true


        TreeNode leaf12 = new TreeNode(4, null, null);
        TreeNode leaf22 = new TreeNode(4, null, null);
        TreeNode leaf32 = new TreeNode(3, null, null);
        TreeNode leaf42 = new TreeNode(2, null, null);
        TreeNode mid22 = new TreeNode(3, leaf12, leaf22);
        TreeNode mid12 = new TreeNode(2, mid22, leaf32);
        TreeNode root2 = new TreeNode(1, mid12, leaf42);
        System.out.println(isBalanced(root2)); //false

    }
}
