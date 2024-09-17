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

// Approach - 1 using BFS
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) 
            return new ArrayList<>();
        
        result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            int largestValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val > largestValue)
                    largestValue = curr.val;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(largestValue);
        }
        return result;
    }
}

// Approach -2 using DFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        dfs(root, result, 0);
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> result, int depth) {
        // base
        if (root == null)
            return;
        // logic
        if (depth == result.size()) {
            result.add(root.val);
        }
        else {
            result.set(depth, Math.max(result.get(depth), root.val));
        }
        // result.get(depth),root.val
        dfs(root.left, result, depth + 1);
        dfs(root.right, result, depth+1);
    }
}
// Executed
// T.C : O(n)
// S.C : O(h)

