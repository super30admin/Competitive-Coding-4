// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
public:
    bool flag = true;
    
    int height(TreeNode* root){
        if(root == NULL)
            return 0;
        int lh = height(root->left);
        int rh = height(root->right);
        
        if(abs(lh-rh)>1){
            flag = false;
        }
        
        return 1 + max(lh,rh);
    }
    
    bool isBalanced(TreeNode* root)
    {
        if(root == NULL)
            return true;
        
        int lh = height(root->left);
        int rh = height(root->right);
        
        if(abs(lh-rh)>1 || flag == false){
            return false;
        }
        return true;
    }
};