// time complexity - O(n)
// space complexity - O(breadth of the tree - 2) 
// Works on leet code
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
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int check = check_height(root);
        if (check == -1 || check == 0){
            return false;
        }
        return true;

    }

    public int check_height(TreeNode node){
        if(node == null){
            return 0;
        }
        int height_left = check_height(node.left);
        int height_right = check_height(node.right);

        // If either left or right is not balanced, then the tree is not balanced
        if(height_left == -1 || height_right == -1){
            return -1;
        }

        // Condition to check if balanced - abs(height-left - height_right) is between 0 to 1
        if(height_left - height_right <-1 || height_left - height_right > 1){
            return -1;
        }
        // Incrementing height by 1 and returning if the subtree is found to be balanced
        return Math.max(height_left, height_right) + 1;
    } 
}
