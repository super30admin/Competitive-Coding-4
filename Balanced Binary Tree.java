/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
*/

//T: O(n)
//S: O(1)
// Using DFS concept, we apply a bottom-up approach. All nodes are needed only once.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        return checkDepth(root) != -1;
    }
    
    public int checkDepth(TreeNode root){
        
        if(root == null)    return 0;
        
        int leftHeight = checkDepth(root.left);
        if(leftHeight == -1)    return -1;
        
        int rightHeight = checkDepth(root.right);
        if(rightHeight == -1)   return -1;
        
        if(Math.abs(leftHeight - rightHeight) > 1)  return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

// T: O(n ^ 2) worst case. This is a Top down approach. At each level for every node we need to make n checks. Therefore in a worst case of unbalanced tree we have O(N ^ 2)
// S: O(1)

// This is a Top-down approach where at every node we check wheather the height difference does not exceed greater than one.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)    return true;
        
        if(Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int getHeight(TreeNode root){
        
        if(root == null) return 0;
        
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}