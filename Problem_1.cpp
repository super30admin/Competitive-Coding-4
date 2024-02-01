/*
 ? Problem: Balanced Binary Tree
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/


#include <algorithm>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {

public:
    bool isBalanced(TreeNode* root) {
        int height = 0;
        return dfs(root, height);
    }
private:
    bool dfs(TreeNode* root, int &height) {
        if(!root) {
            height = -1;
            return true;
        }
        int left = 0, right = 0;

        if(!dfs(root->left, left) || !dfs(root->right, right)) return false;
        if(std::abs(left-right) > 1) return false;
        height = 1 + std::max(left, right);
        return true;
    }
};