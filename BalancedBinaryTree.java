//TC: O(n)
//SC: O(1)
import javax.swing.tree.TreeNode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int height = findHeight(root);
        if(height == -1) return false;
        else return true;

    }
    public int findHeight(TreeNode node) {
        if(node == null) return 0;
        int rightHt = findHeight(node.right);
        int leftHt = findHeight(node.left);
        if(Math.abs(rightHt - leftHt) > 1 || rightHt == -1 || leftHt == -1) {
            return -1;
        }
        else {
            return Math.max(rightHt, leftHt) + 1;
        }
    }
}
