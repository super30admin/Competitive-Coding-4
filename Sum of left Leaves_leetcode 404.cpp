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
 Time Complexity = O(N)
 Space Complexity = O(h)
 where N is the number of nodes of the tree and h is height of the tree.
 */
class Solution {
public:
    int sum=0;
    int sumOfLeftLeaves(TreeNode* root) {
        dfs(root,false);
        return sum;
    }
    void dfs(TreeNode * root, bool flag)
    {
        //base
        if(root==NULL)
            return;
        //logic
        if(root->left==NULL && root->right==NULL)
            if(flag)
                sum+=root->val;
        
        dfs(root->left, true);
        dfs(root->right, false);
    }
};
