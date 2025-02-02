// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // base 
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            max = Integer.MIN_VALUE;
            int n = q.size();
            while(n-- > 0) {
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                max = Math.max(max, node.val);
            }
            res.add(max);
        }
        return res;
    }
}