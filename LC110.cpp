
// Time complexity O(n)
// Space complexity O(h)
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
    std::pair<bool, int> helper(TreeNode* root) {
        if (root == nullptr)
        {
            return {true, 0};
        }
        auto [is_left_balanced, left_height] = helper(root->left);
        auto [is_right_balanced, right_height] = helper(root->right);
        if (abs(left_height - right_height) > 1) {
            return {false, 0};
        }
        return {is_left_balanced && is_right_balanced, 1+max(left_height, right_height)};
    }
public:
    bool isBalanced(TreeNode* root) {     
        return helper(root).first;
    }
};