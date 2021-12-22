//Time complexity : O(n)
//Space complexity : O(h)

//Approach :
            // Calculate height of left and right subtree of every node
            // If the absolute difference is greater than 1 it means that its not a balanced binary tree

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
    bool balanced = true;
    bool isBalanced(TreeNode* root) {
        if(root == nullptr)
            return balanced;
        
        dfs(root);
        
        return balanced;
    }
    
    int dfs(TreeNode* root)
    {
        if(root == nullptr)
            return 0;
        
        int lh = 1 + dfs(root->left);
        int rh = 1 + dfs(root->right);
        if(abs(lh - rh) > 1)
        {
            balanced = false;
        }
        
        return max(lh , rh);
    }
    
    
};