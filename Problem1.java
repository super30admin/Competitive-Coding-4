//Time Complexity: O(n)
//Space Complexity: O(h)
//Code run successfully on LeetCode.

public class Problem1 {

	boolean bal = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        helper(root);
        return bal;
    }
    
    private int helper(TreeNode root){
        
        if(root == null)
         return 0;
        
        int hl = helper(root.left);
        
        if(hl < 0)
        {
             bal = false;
             return -1;
        }
        int hr = helper(root.right);
        
        if( hr < 0)
        {
             bal = false;
             return -1;
        }
        
        else if (Math.abs(hl - hr) > 1)
        {
            bal = false;
            return -1;
        }
        
        return Math.max(hl, hr) + 1;
        
    }
}
