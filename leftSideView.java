// Time complexity - O(n)
// Space complexity - O(1)
//Did this code successfully run on Leetcode : Yes 
//Any problem you faced while coding this : No
//Left side view of binary tree.
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
    public List<Integer> leftSideView(TreeNode root) {
        
        List<Integer> arr1 = new ArrayList<>();
        
        helper(root, arr1, 0);
        
        return arr1;
        
    }
    
    private void helper(TreeNode root, List<Integer> arr1, int currentLevel){
        //Base case
        if(root == null){
            
            return;
        }
        //Logic
        if(currentLevel == arr1.size()){
            
            arr1.add(root.val);
        }
        
        helper(root.left, arr1, currentLevel+1);
        helper(root.right, arr1, currentLevel+1);
        
    }
}