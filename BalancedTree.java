//Time Complexity: O(N)
//Space Complexity: O(H) ; depth of tree
class Solution {
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        height(root);
        return isBalanced;
    }
    public int height(TreeNode node){
        if(node == null){
            return 0;
        }

        int l = height(node.left);
        int r = height(node.right);



        if(Math.abs(l-r)>1){
            isBalanced = false;
        }

        return 1 + Math.max(l,r);
    }
}