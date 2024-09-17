// Time Complexity : O(N)
// Space Complexity : O(N) (Iterative), O(H) (Recursive)
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
    ArrayList<Integer> ans;
    public List<Integer> largestValues(TreeNode root) {
    
        // DFS
        ans = new ArrayList<>();
        // ans.add(-1);
        dfs(root, 0);
        System.out.println(ans);
        
        return ans;
        
        
        // BFS
        // Queue<TreeNode> queue = new LinkedList<>();
        // ArrayList<Integer> res = new ArrayList<>();
        // if(root == null ) return res;
        // queue.add(root);
        // while(!queue.isEmpty()) {
        //     int size = queue.size();
        //     int Max = Integer.MIN_VALUE;
        //     for(int i=0;i<size;i++) {
        //          TreeNode curr = queue.poll();
        //          Max = Math.max(Max,curr.val);
        //         if(curr.left != null) {
        //             queue.add(curr.left);
        //         }
        //         if(curr.right != null) {
        //             queue.add(curr.right);
        //         }
        //     }
        //     res.add(Max);
        // }
        // return res;
        
    }
    
    private void dfs(TreeNode root, int lvl) {
        if(root == null) return;
        
        if(lvl == ans.size()) {
            ans.add(root.val);
        } else {
            ans.set(lvl, Math.max(ans.get(lvl), root.val));
        }
        
        dfs(root.left, lvl+1);
        dfs(root.right, lvl+1);
    }
}
