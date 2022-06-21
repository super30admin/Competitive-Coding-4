// Time Complexity: O(n)
// Space Complexity: O(1)
public class CompetetiveCoding4 {
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(isBalanced(root.left) &&  isBalanced(root.right)) {
            int left = helper(root.left);
            int right = helper(root.right);

            if(Math.abs(left-right) > 1) return false;
            else return true;
        }
        return false;

    }

    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        return Math.max(left, right)+ 1;
    }
}
