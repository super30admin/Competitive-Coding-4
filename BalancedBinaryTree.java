// Time Complexity : O(n logn)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - Use a helper function to get the height of the left and right subtrees.
//    - If the height difference is more than 1 at any node, return false.
//    - Recursively check all subtrees for balance.
//    - A more optimized version avoids repeated height calculations using bottom-up approach

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

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHt = getHeight(root.left);
        int rightHt = getHeight(root.right);

        if(Math.abs(rightHt - leftHt) > 1) {
            return false;
        }

        return isBalanced(root.left) && isB;
    }

    //helper function to get height
    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        BalancedBinaryTree checker = new BalancedBinaryTree();
        TreeNode balancedRoot = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));

        System.out.println("Is tree balanced? " + checker.isBalanced(balancedRoot));
    }
}
