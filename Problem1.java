// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :no

public class Problem1 {
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        //at each level we need to find the height of the sub tress
        heightBalance(root);
        return isBalance;
    }
    public int heightBalance(TreeNode node){
        if(node == null){
            return 0;
        }
        //check the height for left
        int heightleft = heightBalance(node.left);
        //check the height for right
        int heightRight  = heightBalance(node.right);
        //check if height diff is >= 2
        if(Math.abs(heightleft - heightRight)>= 2){
            isBalance = false;
        }
        //now after completing both of the heights we can just return the max among them +1 as we've completed the height for that node too.
        return Math.max(heightleft,heightRight)+1;
    }
}
