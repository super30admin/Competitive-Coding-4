// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
   
    public boolean isBalanced(TreeNode root) {

        //basecase
        if(root==null) return true;

        if(checkHeight(root)==-1){
            return false;
        }
        else{
            return true;
        }

    }

    private int checkHeight(TreeNode root){

        if(root==null) return 0;

        int left = checkHeight(root.left);
        if(left==-1) return -1;
        int right=  checkHeight(root.right);
        if(right==-1) return -1;
        if(Math.abs(left-right) >1) return -1;


        return Math.max(left,right)+1;
    }
    

}