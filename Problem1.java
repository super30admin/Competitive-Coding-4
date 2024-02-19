// https://leetcode.com/problems/balanced-binary-tree/description/

// Time Complexity : O(N), N is number of nodes of tree
// Space Complexity : O(H), H is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    private boolean balanced;

    // Recursively calculate height of left and right subtrees
    // Check for each subtree, reset balanced flag if not balanced
    private int helper(TreeNode root){
        //base
        if(root==null){
            return 0;
        }

        // Get left and right heights
        int leftH=1+helper(root.left);
        if(!balanced){
            return 0;
        }
        int rightH=1+helper(root.right);

        if(Math.abs(leftH-rightH)>1){
            // unbalanced
            // Conditional return
            balanced=false;
        }
        return Math.max(leftH, rightH);
    }

    public boolean isBalanced(TreeNode root) {
        balanced=true;
        helper(root);
        return balanced;
    }
}