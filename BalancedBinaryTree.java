// Time Complexity : O(nodes of tree)
// Space Complexity : O(nodes of tree)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    int val;
    boolean res;
    
    Pair(int val, boolean res){
        this.val=val;
        this.res =res;
    }
    
    public int getVal(){
        return this.val;
    }
    
    public boolean getRes(){
        return this.res;
    }
    
    public void setVal(int val){
         this.val=val;
    }
    
    public void setRes(boolean result){
        this.res=result;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        
        return helper(root, new Pair(0,true)).res;
    }
    
    public Pair helper(TreeNode root, Pair p) {
        if(root==null)
            return p;
        
        Pair left = helper(root.left, p);
        if(left.getRes()==false){
            p.setRes(false);
            return p;
        }
        
        Pair right = helper(root.right, p);
        
        if(right.getRes()==false || Math.abs(left.getVal()-right.getVal())>1)
        {
            p.setRes(false);
            return p;
        }
        
        return new Pair(Math.max(left.val,right.val)+1,true);
    }
}
