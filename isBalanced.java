//TC: O(N)
//SC: O(N)
class Solution {
    boolean flag= true;
    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;
        int height = 0;
        helper(root, height);
        return flag;
    }

    private int helper(TreeNode root, int height){
        //base
        if(root==null)
            return height;

        int leftHeight=0,  rightHeight=0, diff=0;

        //logic
        if(flag == true){
            leftHeight = helper(root.left, height+1);
            rightHeight = helper(root.right, height+1);


            diff = Math.abs(leftHeight-rightHeight);
        }
        if(diff>1){
            flag = false;
        }

        return Math.max(leftHeight, rightHeight);

    }
}