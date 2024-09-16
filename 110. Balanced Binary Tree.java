// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int leftHeight = 0;
    int rightHeight = 0;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(helperHeight(root)!=-1)return true;
        return false;
    }

    public int helperHeight(TreeNode root){
        //base
        if(root == null) return 0;

        //logic
        int left = helperHeight(root.left);
        int right = helperHeight(root.right);
        if(Math.abs(left-right)>1 || left ==-1 || right==-1) return -1;
        return Math.max(left,right)+1;

    }
}
