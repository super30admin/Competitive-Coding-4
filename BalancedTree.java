// Time Complexity : O(n) n is elements of tree nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: if the tree is balanced then the height of its left and right
//should be the same. so at every node, find its left and right height if that's betweek 0 or 1, its valid.
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
public class BalancedTree {
    private static boolean isBalanced(TreeNode root){
        if(root == null) return true;

        return Math.abs(findHeight(root.left) - findHeight(root.right)) < 2 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    private static int findHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(findHeight(root.left), findHeight(root.right)) +1;
    }
}
