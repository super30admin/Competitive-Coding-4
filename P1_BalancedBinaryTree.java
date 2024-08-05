// TC : O(n)
// SC : O(1)
class Solution {
    private boolean flag = true;
    int postOrder(TreeNode node) {
        if(node == null)    return 0;
        int left = 0;
        int right = 0;
        left = postOrder(node.left);
        right = postOrder(node.right);
        if(Math.abs(left-right) > 1) 
            flag = false;
        return 1 + Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        postOrder(root);
        return flag;
    }
}