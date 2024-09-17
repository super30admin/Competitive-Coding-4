TC: O(N) where N is the number of nodes in the Tree;
SC: O(max depth of the tree)

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
        helper(root);
        return global_bool;
        
    }

private:
    int global_bool = true;
    int helper(TreeNode* root){
        if(root == NULL)return 0;
        int left = helper(root->left);
        int right = helper(root->right);
        if(abs(left-right)>1)global_bool = false;
        return max(left,right)+1;
    }
    

};