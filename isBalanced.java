//T.C -> O(nlogn)
//S.C -> O(h) //Height of the tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        if(Math.abs(leftHeight - rightHeight) <= 1)//Check if valid
        {
            return  isBalanced(root.left) && isBalanced(root.right) ;
        }
        else//invalid
        {
            return false;
        }
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
       int left = helper(root.left);
       int right = helper(root.right);
       return Math.max(left, right) + 1;//max value
    }
}