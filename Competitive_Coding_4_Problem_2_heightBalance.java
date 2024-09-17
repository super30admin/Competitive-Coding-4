//Time Complexity : O(n) As we will be traversing each element once
//Space Complexity : O(1)
//Runs successfully on leetcode
//No Problem

//Here we will be checking the difference of length of left and right branch of the tree
//If the difference is greater than 1, we will be returning false.


public class Competitive_Coding_4_Problem_2_heightBalance {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return flag;
    }
    public int helper(TreeNode root)
    {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left-right)>1) flag = false;
        return Math.max(left,right) + 1;
    }
}
