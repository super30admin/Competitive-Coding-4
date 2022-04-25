
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
