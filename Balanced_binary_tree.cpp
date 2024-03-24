// Time Complexity : O(n) .... 
// Space Complexity : O(h)
//                         .... h is height of the tree. This is because stack used for recusrion
//                         .... worst case scenario its O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/balanced-binary-tree/description/

Given a binary tree, determine if it is height-balanced.
*/

class Solution {

public:
    bool isBalanced(TreeNode* root) {
        int result = helper(root);
        if(result == -1) return false;
        return true;
    }

    int helper(TreeNode* root){
        if(root == nullptr) return 0;

        int leftDepth = helper(root->left);
        if(leftDepth == -1) return -1;    

        int rightDepth = helper (root->right);
        if(rightDepth == -1) return -1;

        if(abs(leftDepth - rightDepth) > 1) return -1;
        return std::max(leftDepth, rightDepth) + 1;
    }
};