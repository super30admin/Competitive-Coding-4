// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class BalancedHeightBT {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(heightBT(root.left) - heightBT(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int heightBT(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(heightBT(node.left), heightBT(node.right)) + 1;
    }
}

class BalancedHeightSol2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (heightBT(root) == -1)
            return false;
        return true;
    }

    private int heightBT(TreeNode node) {
        if (node == null)
            return 0;
        int hLeft = heightBT(node.left);
        if (hLeft == -1)
            return -1;

        int hRight = heightBT(node.right);
        if (hRight == -1)
            return -1;

        if (Math.abs(hLeft - hRight) > 1)
            return -1;

        return Math.max(hLeft, hRight) + 1;
    }
}
