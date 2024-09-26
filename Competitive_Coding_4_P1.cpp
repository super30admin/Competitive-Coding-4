/*
Time Complexity: O(m*n)
Space Complexity: O(h)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/

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
    bool flag=true;
    bool isBalanced(TreeNode* root) {
        if(root==NULL) return true;
        height(root);
        return flag;
    }
    int height(TreeNode* node){
        if(node==NULL) return 0;
        int left = height(node->left);
        int right = height(node->right);
        int len = max(left, right)+1;
        if(abs(left-right)>1){
            return flag=false;
        }
        return len;
    }
};