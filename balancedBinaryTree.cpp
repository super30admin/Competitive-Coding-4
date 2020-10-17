//time complexity: O(n)
//space complexity:O(n)
//approach: bottom-up
//solved on leetcode? yes
//problem faced? no

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
        int h=helper(root);
        if(h!=-1)
            return true;
        else
            return false;
        
    }
    
    int helper(TreeNode* root)
    {
        if(root==NULL)
            return 0;
        int lh=helper(root->left);
        int rh=helper(root->right);
        if(abs(lh-rh)>1 || lh==-1 || rh==-1)
            return -1;
        return 1+max(lh,rh);
    }
};