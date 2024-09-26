// Time Complexity : O(n) where  n is no.of nodes
// Space Complexity : O(log h) h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*Approach
 * Approach is to use recursion to iterate all the nodes of the tree and get the height at each level.
 * It the difference in the height of the left and right subtree is greater than 1, tree is not balanced else balanced
 * */


public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if(root==null) return true;

        Pair p = helper(root);
        return p.isBalanced;

    }

    private Pair helper(TreeNode root) {
        if(root==null) return new Pair(true,-1);

        Pair left = helper(root.left);
        Pair right = helper(root.right);
        int ht = Math.max(left.height, right.height)+1;
        if(left.isBalanced==true && right.isBalanced==true){
            int diff = Math.abs(left.height-right.height);
            if(diff<=1){
                return new Pair(true, ht);
            }
        }
        return new Pair(false,ht);
    }

    class Pair{
        boolean isBalanced;
        int height;

        public Pair(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }

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
