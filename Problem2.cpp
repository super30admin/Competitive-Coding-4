// Time Complexity : O(n^2) (pls let me know if this is right, basically everynode is visited & for everynode height is checked)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        if(root == NULL) return true; // edge case
        int ht1 = height(root->left); // get the height of left
        int ht2 = height(root->right);  // get the height of right
        if(abs(ht1-ht2) > 1)return false;  // return false if not balanced
        return (isBalanced(root->left) && isBalanced(root->right));  // recursive call, check balanced for each node
        
    }
    
    int height(TreeNode* root){
        if(root == NULL) return 0;  // null case
        if(root->left == NULL && root->right == NULL) return 1; // if 1 node return 1
        return (1+ max(height(root->left), height(root->right))); // return the height of entire tree
    }
};