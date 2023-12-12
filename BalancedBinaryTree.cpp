//TC: O(n)
//SC:O(1)
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
        //int result = height(root);
        return height(root) != -1;
    }

    private:
    int height(TreeNode* root)
    {
        if(root == NULL) return 0;

        int left = height(root->left);
        int right = height(root->right);

        if(abs(left - right) > 1) return -1;
        if(left == -1 || right == -1) return -1;
        return (max(left,right) + 1);
    }
};