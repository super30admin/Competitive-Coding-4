// Time Complexity : O(n), n is number of nodes
// Space Complexity : O(h), h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Solution : O(n), we got to leaf and then calculate height/depth (instead of calculating height while going to leaf O(n*h))
//Time Complexity : O(n)
//For Binary Tree to be balanced :
//1. Left subtree needs to be balanced
//2. right subtree needs to be balaced
//3. Math.abs(Height(left) - Height(right)) <= 1
//all three statement needs to be true for balanced binary tree
//height/depth of leaf node = 1

class Solution {   
    
    public boolean isBalanced(TreeNode root) {
        
        //if tree is empty (root is null) , tree is balanced, so return true
        if(root == null) return true;
        
        //else check for the three conditions to be balanced Binary Tree
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(height(root.left) - height(root.right)) <=1 );
        
        //for height have a separate function
    }
    
    //method to calculate height, returns int (height)
    private int height (TreeNode root) {
        
        //if curr node is null (height/depth = 0), return 0
        if (root == null) return 0; 
        
        //if curr nodes root.left == null and root.right == null, it is leaf node
        // so return height = 1
        if(root.left == null && root.right == null) {
            return 1;
        }
        
        // if curr node is not leaf, to calc the height, get max height between both the child nodes
        // and add 1 to it, to get height/depth of the node
        // return the height
        //this way we calc height for each node only once
        //and not twice like in regular DFS
        else {
            return (Math.max(height(root.left),height(root.right)) +1 );
        }              
    }
}



/*
//Solution : Calc height of each visited node
//Time Complexity O(n^2), worst case or O(nh)
class Solution {
    
    public boolean isBalanced(TreeNode root) {
        
        //if tree is empty (root is null) , tree is balanced, so return true
        if(root == null) return true;
        
        //calc height of left and right node/child, call the height method
        int left = height(root.left, 1);
        int right = height(root.right, 1);
        
        //if difference of heighs > 1 return false
        if(Math.abs(left - right) > 1 ) return false;
        
        //call recursively for all nodes and check difference between height of siblings
        return isBalanced(root.left) && isBalanced(root.right);        
        
    }

    //method to calculate height of each visited node
    private int height (TreeNode root, int height) {
        
        ////if curr node is null (height/depth = 0), return 0
        if (root == null) return 0;
        
        //if curr node is leaf, return the height
        if(root.left == null && root.right == null) return height; //can return 1 as well, height of leaf = 1

        
        //else to calc the height of the curr node
        //get max height between the children and add 1 to it
        return (Math.max(height(root.left, height), height(root.right, height)) +1); 
        //return Math.max(height(root.left, height+1), height(root.right, height+1)); 
            
    }
}
*/