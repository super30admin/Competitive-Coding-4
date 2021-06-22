/*SC - O(N) TC O(NlogN)
 * DFS way to find the max depth of tree at every node and checking the depth of its left and right child*/

class Solution {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return result;
    }
    public int dfs(TreeNode root){
        if (root == null) return 0  ;
       
       
        int ldepth   = dfs(root.left);
     
      
        int rdepth   = dfs(root.right);
         if ( Math.abs(ldepth-rdepth)>1) {result = false;}
        
        return Math.max(ldepth, rdepth) + 1;
    }
}
