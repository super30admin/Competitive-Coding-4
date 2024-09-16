// Time Complexity :O(n^2) where n is the number of nodes(worst case)
// Space Complexity : O(h) Height of the tree  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if(!root) return true;
        // findLeftHeight
        int leftHeight = findHeight(root->left);
        //findRightHeight
        int rightHeight = findHeight(root->right);
        //Compare and return if false ; if not continue
        if(abs(rightHeight - leftHeight) > 1) return false;
        return isBalanced(root->left) && isBalanced(root->right);    
    }
    // Height func()
    int findHeight(TreeNode* root){
        if(!root) return 0;
        int left = findHeight(root->left);
        int right = findHeight(root-> right);
        return max(left, right) + 1;
    }
};