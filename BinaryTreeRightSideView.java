/**
Daily Problem #58
Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this: N/A
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode current = null;
            for(int i = 0; i< size; i++){
                current = q.poll();
                if(current.left != null) q.add(current.left);
                if(current.right !=null) q.add(current.right);
            }
            result.add(current.val);
        }
        
        return result;
    }
}