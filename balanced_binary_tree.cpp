//Time Complexity-O(n)
//Space Complexity-O(n)
//Ran successfully on leetcode

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
        if(root==NULL)
            return true;
		//Check balance for left and right subtrees
        bool left=isBalanced(root->left);
        bool right=isBalanced(root->right);
        bool flag;
		//Calculate the height of the left and right subtrees qand find their diff
        if(abs(height(root->left)-height(root->right))>1)
            flag=false;
        else
            flag=true;
        return left&&right&&flag;
    }
    int height(TreeNode*root)
    {
        if(root==NULL)
            return 0;
        return max(height(root->left),height(root->right))+1;
    }
};