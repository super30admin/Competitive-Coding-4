
import java.util.*;

class BinaryTreeLevelOrder {

  // Time Complexity : O(N)
  // Space Complexity : O(W) - Max width of the tree (Not sure if this is true)
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
