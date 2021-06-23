//time complexity: O(n)
//space complexity:O(1)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return height(root)!=-1;//if the height of the root is -1
//then it is not balanced
    }
    private int height(TreeNode root)
    {
        if(root==null) return 0;
        int left=height(root.left);//recursive call for the left subtree 
        int right=height(root.right);//recursive call for the right subtree
        if(Math.abs(left-right)>1) return -1;//if the difference between the heights 
//Is greater than 1 return -1
        if(left==-1||right==-1) return -1;
        return Math.max(left,right)+1;//calculate the height as returning 0 when null is 
//found and then moving upwards by adding one to the max of the bottom elements 
    }
}
