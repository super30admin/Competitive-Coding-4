//Time: O(N^2)
//Space: O(1)

public class balancedTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        //condition to check height difference is < 2
        
        if ((Math.abs(height(root.left) - height(root.right))  < 2) && isBalanced(root.left) && isBalanced(root.right))
            return true;
       
        return false;
        
    }
    
    //Calculate the height
    private int height(TreeNode root) {
        if(root == null) return 0;
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}