/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Idea
 * 1. Calculate heights of left tree and right subtree
 * 2. If diff is <= 1 then tree is balanced.
 * 
 */

class BalancedBinaryTree {
    public static class TreeNode {
            int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }
    public int height(TreeNode root){
    
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int height = 1 + Math.max(leftHeight, rightHeight);

        return height;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int difference = Math.abs(leftHeight - rightHeight);

        if(difference <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }

        return false;
        
    }
    public static void main(String[] args){
        System.out.println("BalancedBinaryTree");

        BalancedBinaryTree obj = new BalancedBinaryTree();
        TreeNode root = new TreeNode(3);         
        root.left = new TreeNode(9); 
        root.right = new TreeNode(20); 
        root.right.left = new TreeNode(15); 
        root.right.right = new TreeNode(7); 
        //root.left.left.left = new TreeNode(8);
        System.out.println(obj.isBalanced(root));
    }
}