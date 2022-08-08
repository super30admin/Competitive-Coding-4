// Time Complexity :O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)  return false;
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    public int height(TreeNode root){
        if(root == null)    return 0;
        int left = 1+ height(root.left);
        int right = 1 + height(root.right);
        return Math.max(left,right);
    }
}