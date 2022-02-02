// Time Complexity : O(N) where N is the number of all tree nodes
// Space Complexity : O(H) where H is the height of the tree at any given node
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// applied DFS where we visit the left subtree and the right subtree at each node
// to check if the difference in depth is greater than one, in our base condition
// we check if the flag is already set to false then we don't continue the recursion further

class Solution {

    boolean result;

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        result = true;

        dfs(root);

        return result;
    }

    private int dfs(TreeNode curr){
        //base
        if(curr == null || result == false)
            return 0;

        //logic
        int leftDepth = dfs(curr.left) + 1;
        int rightDepth = dfs(curr.right) + 1;

        if(Math.abs(leftDepth-rightDepth) > 1){
            result = false;
        }

        return Math.max(leftDepth, rightDepth);

    }
}
