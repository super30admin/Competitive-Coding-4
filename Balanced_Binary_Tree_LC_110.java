/*
//Time complexity  - O(N)
Space complexity  - O(H)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
 */

public class Balanced_Binary_Tree_LC_110 {

public boolean isBalanced(TreeNode root) {
    int h = checkkarlo(root);
    //   int h = height(root);
    if(h == -1)
        return false;
    return true;
}


public int checkkarlo(TreeNode root) {

    if (root == null)
    {
        return 0;
    }

    // checking left subtree
    int leftSubtreeHeight = checkkarlo (root.left);
    if (leftSubtreeHeight == -1) return -1;
    // if left subtree is not balanced then the entire tree is also not balanced

    //checking right subtree
    int rightSubtreeHeight = checkkarlo (root.right);
    if (rightSubtreeHeight == -1) return -1;
    // if right subtree is not balanced then the entire          tree is also not balanced

    //checking the difference of left and right subtree for current node
    if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
    {
        return -1;
    }
    //if it is balanced then return the height
    return (Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1);

}
}


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
