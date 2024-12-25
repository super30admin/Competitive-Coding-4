// LC 110
public class HeightBalancedBinaryTree {

    /**
     * Do as the question says.
     * <p>
     * TC: O(n log n)
     * NOTE: log n in the worst case can be 'n' -> O(n^2)
     * for each node we process the left subtree and right subtree till depth to find the height.
     * <p>
     * and then, we recursively process left subtree and right subtree till depth to check is balanced
     * by again calculating the height till depth.
     * i.e. for each node we process till its depth times
     * <p>
     * Hence, O(n * log n)
     * <p>
     * SC: O(H) (for skewed trees H == n)
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // calculate left height and right height
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // check if current root is balanced
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return false;
        }
        // check recursively for left sub tree and right sub tree
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * Avoid unnecessary fxn calls to height() and isBalanced(),
     * by returning an invalid height (-1) in case of unbalanced node.
     * <p>
     * TC: O(n)
     * SC: O(H) (for skewed trees H == n)
     *
     * @param root
     * @return
     */
    public boolean isBalanced_optimized(TreeNode root) {
        return height_optimized(root) != -1;
    }

    private int height_optimized(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height_optimized(root.left);
        if (leftHeight < 0) {
            return -1;
        }
        int rightHeight = height_optimized(root.right);
        if (rightHeight < 0) {
            return -1;
        }
        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
