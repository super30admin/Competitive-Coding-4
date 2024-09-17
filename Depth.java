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
//Time Complexity: O(V).
//Space Complexity: O(H).
class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode polled = q.poll();
                if(polled.left != null)
                    q.add(polled.left);
                if(polled.right != null)
                    q.add(polled.right);
            }
            depth++;
        }
        
        return depth;
    }
}