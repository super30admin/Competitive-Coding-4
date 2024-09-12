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
        List<Integer> result = new ArrayList<>();

        //edge case
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);  //1

        while(!q.isEmpty()) { //2,10
            int size = q.size(); //2
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll(); //10
                if(curr.val > max) {
                    max = curr.val; //10
                }

                if(curr.left != null) {
                    q.add(curr.left); //12
                }
                if(curr.right != null) {
                    q.add(curr.right);//12,14
                }
            }
            result.add(max);
        }
        return result;
    }
}
