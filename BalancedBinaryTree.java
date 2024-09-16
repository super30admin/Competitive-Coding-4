// Approach 1: Calculate height for every node
// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Need to check if all nodes are balanced
// At each node, calculate height of left and right subtree
// If height difference is greater than 1, return false

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode root){
        if(root == null)
            return 0;
        return (1 + Math.max(height(root.left),height(root.right)));
    }
}

// Approach 2: Bottom up approach
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// While calculating height of left and right subtrees from bottom up, we return -1 if at any point the trees are unbalanced

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int height = height(root);
        if(height==-1)
            return false;
        return true;
    }
    private int height(TreeNode root){
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)
            return -1;
        if(left == -1 || right == -1)
            return -1;
        return 1 + Math.max(left,right);
    }
}