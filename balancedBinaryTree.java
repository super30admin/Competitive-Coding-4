//time complexity: O(N)
//Space complexity: O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public boolean isBalanced(TreeNode root) {
        //if tree is not balanced then returns -1
        return dfsHeight(root)!=-1;        
    }
    int dfsHeight(TreeNode root){
        //base case
        if(root==null)
            return 0;
        int leftHeight=dfsHeight(root.left);
        if(leftHeight==-1)
            return -1;
        int rightHeight=dfsHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)>1)
            return -1;
    return Math.max(leftHeight, rightHeight)+1;
        
    }
}