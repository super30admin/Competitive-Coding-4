// Time Complexity :O(n) as we would traverse all the nodes of the tree once in worst case
// Space Complexity : O(log h) where h is the height of the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

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

class BalancedBinaryTree {
    private boolean flag;
    private int height;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        this.flag = true;
        height = postOrder(root);
        return flag;
    }

    private int postOrder(TreeNode node){
        if(node == null ){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }

        int left  = postOrder(node.left);
        int right = postOrder(node.right);

        if(Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}