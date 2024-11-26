
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// DFS

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
    
    int isBalancedRecur( TreeNode* root, bool& flag ){
        if( root == nullptr ){
            return 0;
        }
        
        if( root->left == nullptr && root->right == nullptr ){
            return 1;
        }
        
        int leftcount = isBalancedRecur( root->left, flag );
        int rightcount = isBalancedRecur( root->right, flag );
        
        if( abs( leftcount - rightcount ) > 1 ){
            flag = false;
        }
        
        return 1+ max( leftcount, rightcount);
        
    }

    
    bool isBalanced(TreeNode* root) {
      bool flag = true;
      isBalancedRecur( root, flag );
      return flag;
    }
};
