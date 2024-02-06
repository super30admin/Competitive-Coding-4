// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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

        if(root == null || (root.left == null && root.right == null)) return true;

        Queue<TreeNode> q = new LinkedList<>();
        int highestLevel = (root.left == null || root.right == null) ? 0 : -1;
        int level = 0;

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            if(highestLevel != -1 && Math.abs(level - highestLevel) > 1) return false;
            while(size-- > 0){
                TreeNode node = q.poll();
                if(highestLevel == -1 && (node.left == null && node.right == null)){
                    highestLevel = level;
                }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            level++;
        }

        
        return true;
        
    }
}
