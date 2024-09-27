// Time Complexity : O(n)
// Space Complexity : O(h) , h is height of tree, worst case h = n, n - nodes in tree
// Did this code successfully run on Leetcode : Yes

public class iSBalanced {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;

        int left = height(root.left);
        int right = height(root.right);

        if( left == -1 || right == -1 || Math.abs(left - right) > 1)
            return false;
        else
            return true;
    }

    private int height(TreeNode root){

        //base
        if(root == null) return 0;

        //logic
        int left = height(root.left);
        int right = height(root.right);

        if( left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t9 = new TreeNode(9, t5, t1);
        TreeNode t0 = new TreeNode(0, null, null);
        TreeNode t4 = new TreeNode(4, t9, t0);

        System.out.print("is balanced :" + new iSBalanced().isBalanced(t4));
    }
}
