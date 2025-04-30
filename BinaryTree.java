
// Time Complexity : O(n)
// Space Complexity: O(h)
// Recursively compute height of left and right subtrees
// If difference in height is more than 1, mark the flag as false
// Return the height of the current node


class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
       
        helper(root);
        return flag;
        
    }
    public int helper(TreeNode root){
        if(root == null){
            return -1;
        }

        //logic
        int left = helper(root.left);
        int right = helper(root.right);

        if(Math.abs(left-right)>1){
            flag = false;
        }
       
        return Math.max(left,right)+1;
    }
}