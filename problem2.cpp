// Time Complexity :  O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we do bottom up recurrsion to avoid repeated calculation of height of a child node.



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
        if(root == NULL) return true;
        int h = 0;
        return helper(root,h);
    }
    bool helper(TreeNode* root, int &height)
    {
        //base
        if(root==NULL) {
            height = -1;
            return true;
        }
        
        //logic
        int left = 0,right = 0;
        if(helper(root->left,left) && helper(root->right,right) && (abs(left - right)<=1))
        {
            height = max(left,right) + 1;
            return true;
        }
        return false;
    }
};