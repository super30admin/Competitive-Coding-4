//Used a recursive top down approach, but a few test cases are failing in with this approach.

class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root,0);
    }
    public boolean helper(TreeNode root, int height){
        TreeNode leftT = root.left;
        TreeNode rightT = root.right;
        //Base case
        if(root==null) return true;
        if((leftT==null)&&(rightT==null)) return true;
        if((leftT.left==null&&leftT.right==null)&&(rightT.left==null&&rightT.right==null)) return true;
        if(leftT.left==null&&leftT.right==null){
            if((rightT.left.left==null&&rightT.left.right==null)&&(rightT.right.left==null&&rightT.right.right==null)) return true;
        else return false;
        }
    if(rightT.left==null&&rightT.right==null){
        if((leftT.left.left==null&&leftT.left.right==null)&&(leftT.right.left==null&&leftT.right.right==null)) return true;
    }
        
        
        helper(root.left,height+1);
        helper(root.right,height+1);
        return true;
        
    }
}
