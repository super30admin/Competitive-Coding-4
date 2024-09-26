
public class Balanced_Binary_Tree {
	//Approach: Recursion
	//1. Here I have used recursion and postorder traversal. Considering a smaller subtree, I will check the left child's height and the right child's height. if their absolute 
	//difference is more than 1, then the tree is not balanced and return false.
	//2. Result is stored as a global variable and height of the tree is returned fro m each recursion since we are calculating height from leaf nodes.
	boolean result;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        result = true;
        helper(root, 0);
        return result;
    }
    public int helper(TreeNode root, int height)
    {
        if(root == null)
	        return 0;
        int left = helper(root.left, 0);
        int right = helper(root.right, 0);
        if(Math.abs(left - right) > 1)
            result = false; 
        return Math.max(left, right)+1;
    }
}
//Time Complexity : O(n) where n is the number of nodes in the tree
//Space Complexity : O(n) where n is the nodes in the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
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