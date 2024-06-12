/**
Daily Problem #56
Time Complexity : O(N^2)
Space Complexity : O(NM)? 
Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this: 
    I didn't remember how to traverse a binary tree so I had to google it
    Once I refreshed my memory I was able to come up with a solution that used recursion
    It took me some debugging but my solution was able to pass all test cases
    I spent about 1 hour to get the final solution
 */

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                List<Integer> level = new ArrayList<>();
                for(int i = 0; i < size; i++){
                    TreeNode current = q.poll();
                    level.add(current.val);
                    if(current.left != null) q.add(current.left);
                    if(current.right != null) q.add(current.right);
                }
                result.add(level);
            }
            return result;
    }
}