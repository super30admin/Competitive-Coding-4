/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
LeetCode Submitted : YES
Space Complexity : O(1)
Time Complexity : O(N*heightof tree)

The idea is to calculate height of left and right sub tree of each node recursively and check if their absolute value > 1 or not.
**/


class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        //System.out.println(checkHeight(root));
        int heightL = 1 + checkHeight(root.left);
        int heightR = 1 + checkHeight(root.right);
        //System.out.println(heightL);
        //System.out.println(heightR);
        
        if(Math.abs(heightL - heightR) > 1){
            return false;
        }
            
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
    
    private int checkHeight(TreeNode root){
        if(root == null)
            return 0;
        
        
        int left  = 1 + checkHeight(root.left);
        int right = 1 + checkHeight(root.right);
        //System.out.println(left);
        //System.out.println(right);
        //System.out.println("--------------");
        if(left > right)
            return left;
        
        return right;
    }
}
