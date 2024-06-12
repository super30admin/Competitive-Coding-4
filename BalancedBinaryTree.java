/**
Daily Problem #55
Time Complexity : O(N)
Space Complexity : O(NM)? 
Did this code successfully run on Leetcode : 
    Yes Runtime: 100% faster , Memory usage 75% less
Any problem you faced while coding this: 
    I didn't remember how to traverse a binary tree so I had to google it
    Once I refreshed my memory I was able to come up with a solution that used recursion
    It took me some debugging but my solution was able to pass all test cases
    I spent about 1 hour to get the final solution
 */

class Solution {
   public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }  
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        // Get the maximum depth 
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
