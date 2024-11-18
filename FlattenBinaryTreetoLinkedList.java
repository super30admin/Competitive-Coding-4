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
// Approach : Recursion - Pre order traversal
// Time : O(n)
// Space : O(h) # recursion space
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;

        root.left = null; // left needs to be null

        flatten(tempLeft);
        flatten(tempRight);

        // Attaching or swapping left node towards right
        root.right = tempLeft;
        
        // Need a node to traverse
        TreeNode current = root;

        // traversing through end of the newly added tempLeft
        while(current.right!=null){
            current=current.right;
        }
        // on right side reached to end of the newly added templeft 
        current.right = tempRight;
    }
}

