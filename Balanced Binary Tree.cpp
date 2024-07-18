// time: O(n)
// space: O(1), except recursive stack

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
    bool flag = true;
    int helper(TreeNode* root) {
        if(root == NULL) {
            return 0;

        }
        int left = helper(root -> left);
        int right = helper(root -> right);
        if(abs(left-right) > 1) {
            flag = false;
            return 0;
        }
        return(max(left,right)+1);
    }
    bool isBalanced(TreeNode* root) {
        int temp = helper(root);
        return flag;
    }
};