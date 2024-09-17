// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class BalancedBinaryTree{
    static boolean isBalanced = true;

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
        if(root == null) return isBalanced;
        helper(root);
        return isBalanced;
    }
    
    public static int helper(TreeNode root){
        // base case
        // Height of the tree when node is null.
        if(root == null) return 0;
        
        // logic
        // Calculate the height of the left and the right sub trees.
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        
        // check the absolute difference of the heights between the left and the right sub trees.
        // If the difference in the heights is greater than 1 then the tree is not balanced
        if(Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }
        
        // Propagating the height of the current node to the parent tree.
        // Height of the parent node is equal to 1 + Math.max(height of left sub tree, height of right sub tree)
        // 1 in the above equation is to include the height of the current node.
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(12, new TreeNode(20), new TreeNode(22));
        root.left = left;
        root.right = right;
        System.out.println("Original tree is balanced: " + isBalanced(root));
        root.left = null;
        System.out.println("Updated tree is balanced: " + isBalanced(root));
    }
}