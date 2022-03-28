//Time Complexity O(n)
//Space Complexity O(h) stack space of recursive calls
//Leetcode tested

public class BalancedBinaryTree {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        int h =helper(root,0);
        return flag;
    }
    public int helper(TreeNode root, int h){
        //base
        if(root == null) return 0;
        int leftH = helper(root.left,h);
        int rightH = helper(root.right,h);
        if(Math.abs(leftH-rightH) > 1) flag= false;
        return Math.max(leftH,rightH)+1;
    }
}
