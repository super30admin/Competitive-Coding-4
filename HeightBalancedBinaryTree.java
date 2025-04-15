// Time Complexity : 0(n)
// Space Complexity :0(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
It uses a recursive helper function to compute the height of each subtree while also
checking the balance condition. If any subtree violates the balance condition,
a boolean flag is set to false and the recursion short-circuits further checks.
The final result is returned after the entire tree is processed.
The solution runs in O(n) time and uses O(h) space, where h is the height of the tree.
* */
class HeightBalancedBinaryTree {
    boolean result=true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root)
    {
        if(root==null || result==false)
            return 0;
        int length1=helper(root.left);
        int length2=helper(root.right);

        if(Math.abs(length1 - length2)>1)
            result=false;
        return Math.max(length1,length2)+1;
    }

}
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