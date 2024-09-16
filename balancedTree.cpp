/*
Intuition: Balanced tree deals with heights(int). Make a helper function that returns int.
For each node it is required that we get its height using its child.
A null node will have height = 0.
We simply take the max of the leafs and add by 1 and pass that to the next recursive call.
No need to use localilzed variables as it the depth does not have to be passed when an element is popped.
#####################################################################
Time Complexity : O(N) 
Space Complexity : O(1)
#####################################################################
*/

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
        
        if (root == NULL){
            return true;
        }
        return isBalanced(root->left) and isBalanced(root->right) and abs(height(root->right)- height(root->left))<= 1;
    }
    
    int height(TreeNode *root){
    
        if (root == NULL){
            return 0;
        }
        int depth1 = height(root->left);
        int depth2 = height(root->right);
        return max(depth1, depth2) + 1;

    }
};