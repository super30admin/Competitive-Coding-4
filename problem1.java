// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


public class problem1 {

 public boolean isBalanced(TreeNode root) {
        
        if(root==null)
            return true;
        
        int size=Math.abs(heightOfTee(root.left)-heightOfTee(root.right));
        
        return size < 2 && isBalanced(root.left)
            && 
            isBalanced(root.right);
        
        
    }
    
    private int heightOfTee(TreeNode root){
        
        if(root==null)
            return -1;
        
        
        return 1+ Math.max(heightOfTee(root.left),heightOfTee(root.right));
        
    }
    
    
}
