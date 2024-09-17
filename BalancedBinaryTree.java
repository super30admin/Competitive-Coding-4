// Time Complexity: O(n)
// Space Complexity: O(n)
// Bottom up Approach
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return height(root) != -1;
    }
    
    // if any node is unbalanced need not calculate height for other nodes just return -1
    private int height(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(lh == -1 || rh == -1)
            return -1;
        
        else if(Math.abs(lh - rh) > 1)
            return -1;
        
        return Math.max(lh,rh) + 1;
    }
}

// Time Complexity: O(nlogn)
// calculate height of each node costs n
// if it is a balanced BT we repeat it for each and every level i.e height of BT log n
// hence the time complexity is (height for each node) * (height of BBT)
// Space Complexity: O(n)
// Top Down Approach
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        // check if root is balanced
        if(Math.abs(height(root.left) - height(root.right)) > 1)
            return false;
        // check if children of root is balanced
        return isBalanced(root.left) && isBalanced(root.right);  // calculate height of each node
    }
    
    
    private int height(TreeNode root) // O(n)
    {
        if(root == null)
            return 0;
        
       return Math.max(height(root.left), height(root.right))+ 1;
    }
}
