/*
Time complexity - O(N)
Space complexity - O(H)
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
    bool res = true;
    bool isBalanced(TreeNode* root) {
        if (!root) return res;
        helper(root);
        return res;
    }
    
private:
    int helper(TreeNode* root){
        if (!root || !res) return 0;
        int L = helper(root->left);
        int R = helper(root->right);
        if (abs(R - L) > 1){
            res = false; return 0;
        }
        return max(L,R) + 1;
    }
};