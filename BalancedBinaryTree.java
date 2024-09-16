// 110. Balanced Binary Tree
// https://leetcode.com/problems/balanced-binary-tree/

//The time complexity is O(n), because we may traverse the whole tree.
//Space complexity: o(N) The recursion stack may go up to O(n) if the tree is unbalanced.
/*
Approach:  I use a global variable to control recursion. 
When we find one subtree is not balanced. 
We don't need to traverse the rest of the nodes. 
*/
class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
      
        helper(root) ;
        return flag;
       }
       public int helper(TreeNode root){
           if(root == null) return 0; 
           int left = helper(root.left);
           int right = helper(root.right);
           
           // Use the height obtained from the recursive calls to
          // determine if the current node is also balanced.
           if(Math.abs(left-right)>1) {
               flag = false;
           }
           return (Math.max(left, right)+1);
    }
}