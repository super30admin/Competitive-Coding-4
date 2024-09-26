//time complexity: O(n)
//space complexity: O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        //base case
        if(root == null) return true;
        //check the tree height if it is not balanced
        return height(root) != -1; 
    }
    private int height(TreeNode node){
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        int distance = Math.abs(left - right);
        //check the conditions if the tree is balanced or not
        if(distance > 1 || left == -1 || right == -1 ) return -1;
        //return the maximum height of the left and right tree
         return 1 + Math.max(left, right);
    }
}