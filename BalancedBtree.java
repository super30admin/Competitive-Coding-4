/**
// Time Complexity : O(n)
// Space Complexity : O(h) h = height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
nope

// Your code here along with comments explaining your approach
// do a post order trversal. at each node in post order , cal left
//and right height of subtree.
//if diff is greater than 1. return -1.
//if not return max height +1.

 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(helper(root) < 0 ){
            return false;
        }
        return true;
    }

    private int helper(TreeNode node){
        if(node == null)
            return 0;

        int left = helper(node.left);
        if(left == -1)
            return -1;
        int right = helper(node.right);
        if(right == -1)
            return -1;

        if(Math.abs(left - right) > 1)
            return -1;

        return (Math.max(left, right) + 1);
    }
}
