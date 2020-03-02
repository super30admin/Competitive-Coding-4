/*

Time: O(N), where N is # of the nodes in the tree
Space: O(1)

Passed All Test Cases 

*/


//using global variable 

class Solution {
    
    int ans = 0 ; 
    
    public boolean isBalanced(TreeNode root) {
        //edge case 
        if(root == null) return true ; 
        getDepth(root) ; 
        return(ans != -1) ; 
    }
    
    private int getDepth(TreeNode root) {
        //base case
        if(root == null) return 0 ; 
        
        int left = getDepth(root.left) ; 
        int right = getDepth(root.right) ; 
        
        if(Math.abs(left - right) > 1) ans = -1 ; 
        
        return (Math.max(left, right) + 1) ; 
    }
}



//without using global variable 

class Solution {
    public boolean isBalanced(TreeNode root) {
        //edge case 
        if(root == null) return true ;
        
        int left = getDepth(root.left) ; 
        int right = getDepth(root.right) ; 
        
        return (Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right) ; 

    }
    
    private int getDepth(TreeNode root) {
        //base case
        if(root == null) return 0 ; 
        
        int left = getDepth(root.left) ; 
        int right = getDepth(root.right) ; 
        
        return (Math.max(left, right) + 1) ; 
    }
}
