/**
https://leetcode.com/problems/balanced-binary-tree/
 
Time Complexity :   O (N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (110. Balanced Binary Tree)
Any problem you faced while coding this :       No
 */

// Input: root = [3,9,20,null,null,15,7]
// Output: true

class IsBalanced {
    boolean flag = true;    //setting the balanced flag default by true 
    public boolean isBalanced(TreeNode root) {
        //base case for null graph 
        if(root == null)
            return true;
        
        //calculates the height and the balance factor simultaneously for each subtree 
        helper(root);
        return flag;
    }
    
    //Height is calculated on the basis of node
    // DFS(postorder)
    public int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int max = Math.max(left, right) + 1;
        
        if(Math.abs(left-right) > 1)
            flag = false;
        return max;
    }
}