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
        if(root == null) return 0;
        
        // logic
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        
        if(Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }
        
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