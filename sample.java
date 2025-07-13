// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isBalanced(TreeNode root) {

       return dfs(root)!=-1;   

    }
   public int dfs(TreeNode root){
    if (root==null){
        return 0;
    }
    int rleft=dfs(root.left);
    if (rleft==-1){
        return -1;
    }
    int rright=dfs(root.right);
    //System.out.println(rleft+"--"+rright);
    if (rright==-1){
        return -1;
    }
     if(Math.abs(rleft-rright)>1){
      return -1;
     }
    //System.out.println(Math.max(rleft ,rright)+1);
     return Math.max(rleft,rright)+1;
      
     
     

   }
}
