package CompetitiveCoding4;

public class question59_BalancedBinaryTree {
    /* Created by palak on 6/23/2021 */

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
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

    /*
        Here we are going to have a recursive solution in whcih we will check for whether left and right subtree is balanced or not;
        Along with that we will also check whether the difference of the height at the current node is less than or equal to 1 or not
        After checking these 3 conditions for every node recursively we will tell the final result.

        Time Complexity: O(nlogn)
        Space Complexity: O(n)
    */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.right) - height(root.left)) <= 1;
    }

    private int height(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }


    /*
        Bottom Up Recursion O(n) time. We check the height balance at children first.
        If the height at children is not balanced. We are returning -1 to parent.
        Check the balance of tree at time of checking height itself.

        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    public boolean isBalanced1(TreeNode root) {
        return height1(root) != -1;
    }

    private int height1(TreeNode root) {
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);

        if(Math.abs(left - right) > 1 || left == -1 || right == -1) return -1;

        return 1 + Math.max(left, right);
    }

    public boolean isBalanced2(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(height2(root.right) - height2(root.left)) > 1) return false;
        return isBalanced2(root.left) && isBalanced2(root.right);
    }

    private int height2(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(height2(root.right), height2(root.left));
    }

    public static void main(String[] args) {

    }
}