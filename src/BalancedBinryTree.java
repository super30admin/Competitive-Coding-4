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

// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {

    private boolean isBalanced = true;
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)                                      // if null tree
            return true;
        helper(root);
        return isBalanced;
    }

    private int helper(TreeNode node) {

        // base
        if(node.left == null && node.right == null)           // leaf node
            return 1;                                         // return height 1

        // logic
        int left = 0;
        int right = 0;
        if(node.left != null) {
            left = helper(node.left);                         // get height or left subtree
        }
        if(node.right != null) {
            right = helper(node.right);                       // get height or right subtree
        }

        if(Math.abs(left - right) > 1) {                      // check whether this node is balanced or not
            isBalanced = false;                               // change flag if not balanced 
        }

        return (Math.max(left, right) + 1);                   // return current height to parent
//         return (((left>right) ? left : right) + 1);           // return current height to parent

    }

}




// ******************** Another approach two recursion without extra variable ********************

class Solution {
    
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)                                                        // if null tree
            return true;
        
        boolean left = isBalanced(root.left);                                   // recursion for balanced left subtree 
        boolean right = isBalanced(root.right);                                 // recursion for balanced right subtree

        int left_height = height(root.left);                                    // recursion for height left subtree
        int right_height = height(root.right);                                  // recursion for height right subtree

        if( Math.abs(left_height - right_height) > 1 )                          // node unbalanced
            return false;                                                       

        return left && right;

    }

    private int height(TreeNode node) {

        if(node == null)                                                        // null node height -1 so that left node height 0
            return -1;

        return ( Math.max(height(node.left), height(node.right)) + 1 );         // return current node height

    }

}
