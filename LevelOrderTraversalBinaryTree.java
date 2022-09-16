// BFS approach : TC - O(n), SC - O(n)
// DFS Approach : TC - O(n), SC - O(h) but in worst case if we have skew tree then it will be O(n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // BFS approach

    static class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root==null) return result;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            // BFS
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> temp = new ArrayList<>();
                for (int i=0; i<size; i++){
                    TreeNode curr = q.poll();
                    temp.add(curr.val);
                    // put the children to queue
                    if (curr.left != null) q.add(curr.left);
                    if(curr.right!=null) q.add(curr.right)
                            ;            }
                result.add(temp);
            }
            return result;
        }
    }

    // DFS approach

    static class Solution2 {
        List<List<Integer>> result;
        public List<List<Integer>> levelOrder(TreeNode root) {
            result = new ArrayList<>();
            if (root==null) return result;
            dfs(root,0);
            return result;
        }

        private void dfs(TreeNode root, int depth) {
            // base
            if (root==null) return;

            // logic
            if (depth == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(depth).add(root.val);
            dfs(root.left,depth+1);
            dfs(root.right,depth+1);
        }
    }

}
