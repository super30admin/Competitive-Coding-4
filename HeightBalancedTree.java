package com.ds.rani.tree;

/**
 * You are given a binary tree find if it is height-balanced or not. for this problem assume that height -balanced tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 * given the following tree [31,9,20,null,null,15,7]:
 *
 *    31
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,20,20,30,30,null,null,40,40]:
 *
 *        1
 *       / \
 *     20   20
 *     / \
 *    30  30
 *   / \
 *  40   40
 *
 * Return false.
 */

//Approach:calculate height of the left subtree, right subtree and check there absolute difference is less than or equal to 1.
//And those both trees should be individually balanced

//Time Complexity:o(n log n)
//Space complexity:o(1) as there is no extra space used but internally it uses o(h) stack space
public class HeightBalancedTree {

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(height(root.left)-height(root.right))<=1);

    }
    int height( TreeNode root){
        if(root==null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }

}
