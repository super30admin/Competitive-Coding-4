/**
*  Time Complexity : O(N)
// Space Complexity : O(H) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        if(root==nullptr){
            return true;
        }

        int a = dfs(root);
        if(a==-1) return false;
        return true;
    }

    int dfs(TreeNode* root){

        if(root==nullptr){
            return 0;
        }
               
        int left = dfs(root->left);
        int right = dfs(root->right); 

        if(left==-1 || right==-1 || abs(left-right)>1){
            return -1;
        }

        return max(left, right) + 1;


    }
};