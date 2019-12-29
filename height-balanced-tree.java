/*

Did it run on leetcode: yes
Time Complexity: 0(NLogN)
Space Compelxity: 0(LogN)

Algorithm: (Bottom Up Approach)
- for each node, obtain leftSubtree Height and rightSubtree height and calculate lh-rh.
- and recursively move to the parent.
- if at any point you get -1, its not a height balanced tree


*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        int height= this.isBalancedHelper(root);
        return height==-1? false:true;
    }
    
    public int isBalancedHelper(TreeNode node){
        
        if(node!=null){
            
            int leftHeight = this.isBalancedHelper(node.left);
            if(leftHeight==-1){ return -1; }
            
            int rightHeight = this.isBalancedHelper(node.right);
            if(rightHeight==-1){ return -1; }
            
            if(Math.abs(leftHeight-rightHeight)==1 || Math.abs(leftHeight-rightHeight)==0){
                return Math.max(leftHeight,rightHeight)+1;
            }else{
                return -1;
            }
            
        }else{
            return 0;
        }
    }
}
