// Time Complexity : O(NlogN) -> log(N) is the height of the binary Tree. We calculate the height N times(for each Node) so it's O(NlogN)
// Space Complexity : O(max(depth))
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Calculate height on each node, return false when diff between left & right substree is >1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        int left = dfs(root.left,0);
        int right = dfs(root.right,0);

        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode root, int size){
        if(root==null)
            return size;

        int left = dfs(root.left,size+1);
        int right = dfs(root.right,size+1);

        return Math.max(left,right);
    }
}