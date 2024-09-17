
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Q1: balanced trees 

//Algorithm : traverse the tree from root , at every level keep track of the height of current node to previous and also check if the difference is 1 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(check_height(root.left) - check_height(root.right))<=1);                                                             
    }
    public int check_height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(check_height(root.left),check_height(root.right));
    }
}
  


// Time Complexity : 0(N)
// Space Complexity :0(1)
    





Q2 : cousins of binary tree

//Logic: check following conditions
//if depth of x = depth of y 
 //depth.ancestor != ancestor of y


 // Time Complexity : 0(N)
// Space Complexity :0(N)
class Solution {
    TreeNode xpar = null;
    TreeNode ypar = null;
    int xdepth = -1, ydepth = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        checkDepthAndParent(root,x,y,0,null);
        return xpar!=ypar && xdepth == ydepth ? true : false;
    }
    
     //get both the depth and parent for x and y
   public void checkDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
       if(root==null) return ;
       //if any given value is equal to root.val
       if(root.val == x){
           xpar = parent;
           xdepth = depth;
       }else if (root.val == y){
           ypar = parent;
           ydepth = depth;
       }
       checkDepthAndParent(root.left, x, y, depth + 1, root);
       checkDepthAndParent(root.right, x, y, depth + 1, root);
    }
}


    
    
   
   
        
                                                                   
                                                                   
