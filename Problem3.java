/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
Leet Code Submitted : YES (Mock Interview not able to solve completely)
Time Complexity : O(N)
Space Complexity : O(1)
The idea is to locate root of the sub tree and then compare each node of the subtree recursively with parent tree. Once all the nodes are compared return true else return false.
**/

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null)
            return false;
        
        if(check(s,t))
            return true;
        
        return (isSubtree(s.left,t) || isSubtree(s.right,t));  
        
    }
    
    private boolean check(TreeNode s , TreeNode t){
        if(s == null && t== null)
            return true;
        
        if(s == null || t == null)
            return false;
      
        if(s.val != t.val){
           return false;
        }
        
        return check(s.left,t.left) && check(s.right,t.right);
    }
}
