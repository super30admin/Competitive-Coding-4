public class BalancedBinaryTree {

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

    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
       /*
       TC: O(n) where n are the no of nodes in the tree
       SC: O(Height)-> O(n)
       */
        if(root==null){
            return true;
        }

        isBalanced=true;
        helper(root);//TOD0
        return isBalanced;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }

        int left= helper(root.left);
        int right=helper(root.right);
        int diff=Math.abs(left-right);

        if(diff>1){
            isBalanced=false;
        }

        return Math.max(left,right)+1;
    }

}
