
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Level order traversal and find max at each level and add to result after complete level is parsed
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//Definition for a binary tree node.
   class TreeNode {
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

class GreatestValueInEachRow {
    public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            result.add(root.val);
            while (!queue.isEmpty()) {
                int i = queue.size();
                int max = Integer.MIN_VALUE;
                while (i > 0) {
                    TreeNode temp = queue.poll();
                    if (temp.left != null) {
                        queue.add(temp.left);
                        max = Math.max(max, temp.left.val);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                        max = Math.max(max, temp.right.val);
                    }
                    i--;
                }
                result.add(max);
            }
            result.remove(result.size() - 1);
            return result;
        }
}