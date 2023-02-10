// ######### APPROACH 1: Calculate height for every node ############
// Time Complexity : O(nlogn)
// Space Complexity : O(n)

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode root){
        if(root == null)
            return 0;
        return (1 + Math.max(height(root.left),height(root.right)));
    }
}

// ########## APPROACH 2: Bottoms Up ############
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int height = height(root);
        if(height==-1)
            return false;
        return true;
    }
    private int height(TreeNode root){
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)
            return -1;
        if(left == -1 || right == -1)
            return -1;
        return 1 + Math.max(left,right);
    }
}