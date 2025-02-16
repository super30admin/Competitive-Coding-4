// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursively check if a node has left and right child, and calculate the height using max(left,right)+1.
// At each node, check if the height (left - right) > 1, if true return -1. Similarly, check if either of right or left child has a value -1.
// This ensures that we are exiting when the tree is unbalalnced at one point instead of checking the whole tree.

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
        int helper(TreeNode* root){
            if(root == NULL) return 0;
    
            int left = helper(root->left);
            if(left == -1) return -1;
    
            int right = helper(root->right);
            if(right == -1) return -1;
    
            if(abs(left-right) > 1) return -1;
    
            return max(left,right)+1;
    
        }
        bool isBalanced(TreeNode* root) {
            return helper(root)!=-1;
        
        }
    };