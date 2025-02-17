//The approach here is to check if a tree is balanced or not by calculating the height of the tree from bottom to top. At any node, if that node is balanced, we return the height of that tree to its parent.
//If the node is unbalanced, then we send the height of that tree as -1.
//Time complexity: O(n)
//Space Complexity: O(n)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int rootHeight = height(root);
        if(rootHeight != -1){
            return true;
        }
        return false;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }        
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh-rh) > 1) return -1;
        if(lh == -1 || rh == -1) return -1;
        return Math.max(lh,rh) + 1;
    }
}