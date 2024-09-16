    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/balanced-binary-tree/
    Time Complexity for operators : o(nlog(n)) .. number of  elements in the matrix
    Extra Space Complexity for operators : o(n) ... recursive stack in case of recusrin and normal stack for iterative 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach :
                              
            # 1st one - Recursive Approach
                    A. call the recusion function with root.left and root.right and check the difference.
                    B. The difference must be below 2 else it is not balanced return false;
                    C. We need to check balance for each of the subtree. For that call isBal;anced function again 
                       for root.left and roo.right
                    D. if everything is good then return true at the end.

       */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

   class validateBST {

          //below solution is also valid but it will not make sure about the sub trees. 
       public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        // int heightLeft = recursion(root.left);
        // output = Integer.MIN_VALUE;
        // int heightRight = recursion(root.right);
        // System.out.println(heightLeft);
        // System.out.println(heightRight);
        return ((Math.abs(recursion(root.left) - recursion(root.right)) < 2)  && isBalanced(root.left)
               && isBalanced(root.right));
    }
    int output = Integer.MIN_VALUE;
    public int recursion(TreeNode root){
        if(root == null)
            return -1;

        
        return 1 + Math.max(recursion(root.left),
        recursion(root.right));
        
    }
}