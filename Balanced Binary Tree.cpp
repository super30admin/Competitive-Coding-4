//Time Complexity- O(n^2)
//Space Complexity- O(n) (Auxilliary Stack)

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        
        if(root==NULL){
            return true;
        }
        
        int lheight=height(root->left);
        int rheight=height(root->right);
        
        return (abs(lheight-rheight))<=1 && isBalanced(root->left) && isBalanced(root->right);
    }
    
    int height(TreeNode* root){
        if(root==NULL){
            return 0;
        }
        
        int lheight=height(root->left);
        int rheight=height(root->right);
        
        return max(lheight,rheight)+1;
    }
};