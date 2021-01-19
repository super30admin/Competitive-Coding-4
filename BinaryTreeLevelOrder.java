
import java.util.*;

class BinaryTreeLevelOrder {

  // Time Complexity : O(N)
  // Space Complexity : O(N/2) = O(N) | max number of nodes at any time would be equal to number of leaf nodes
  // Did this code successfully run on Leetcode : YES
  // Any problem you faced while coding this : NO

public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if(root == null) return output;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> currLevel = new ArrayList<>();
            while(size > 0){
                TreeNode currNode = que.remove();
                currLevel.add(currNode.val);

                if(currNode.left != null) que.add(currNode.left);
                if(currNode.right != null) que.add(currNode.right);


                size--;
            }

            output.add(currLevel);
        }

        return output;
    }


    // Time Complexity : O(N)
    // Space Complexity : O(H) | H = height of a tree (Considering recursive stack space)
    // Did this code successfully run on Leetcode : YES
    // Any problem you faced while coding this : NO
    // USE DFS, maintain node's level in each node's recursive stack.

    List<List<Integer>> result;
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
      result = new ArrayList<>();
      if(root == null) return result;
      dfs(root, 0);
      return result;
    }

    public void dfs(TreeNode root, int level) {
      // base
      if(root == null) return;

        // logic
        if(level == result.siz()){
          result.add(new ArrayList<>());
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);

    }

    public class TreeNode {
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
}
