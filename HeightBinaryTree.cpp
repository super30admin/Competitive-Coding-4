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
    bool flag = true;
    int helper(TreeNode *root,int count)
    {
        //base case
        if(root == NULL)
            return 0;

        //at each level we want to increment the count
        
        count++; //4
        
        //traverse
        int left_count = helper(root->left,count); // count 4 
        int right_count = helper(root->right,count); //1   //4

        if(abs(right_count - left_count) > 1)
        {
            flag = false;
        }

        return max(left_count,right_count)+1;
        
    }
public:
    bool isBalanced(TreeNode* root) {
        int count = 0;
        helper(root,count);
        return flag;
    }   
};