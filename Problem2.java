// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// We will use a recursive function to check the height of the left and right subtrees
// If the difference in heights is more than 1 at any node, we set a flag to false
// Finally, we return the flag indicating if the tree is balanced or not

class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.flag=true;
        helper(root,0);
        return flag;
    }
    private int helper(TreeNode root,int height){
        if(root==null) return 0;  //base case when root is null

        int left=helper(root.left,height+1);            
        int right=helper(root.right,height+1);

        if(Math.abs(left-right)>1){
            flag=false;
        }
        return Math.max(left,right)+1;
    }
}