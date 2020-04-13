// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BalancedBinaryTree {

    // Top-down approach O(nlog(n)), Space : O(1)
    public boolean isBalancedTD(TreeNode root) {
        if(root == null){
            return true;
        }
        return (Math.abs(heightTD(root.left) - heightTD(root.right)) < 2) && isBalancedTD(root.left) && isBalancedTD(root.right);
    }

    private int heightTD(TreeNode root){
        if(root == null){
            return -1;
        }

        return 1 + Math.max(heightTD(root.left), heightTD(root.right));
    }

    // Bottom-up
    public boolean isBalancedBU(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        if(leftHeight == -1){
            return -1;
        }

        int rightHeight = height(root.right);
        if(rightHeight == -1){
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
