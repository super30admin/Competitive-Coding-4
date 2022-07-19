class Solution {
public:
    //Time complexity:o(nlogn)
    //Space complexity :O(n). The recursion stack may contain all nodes if the tree is skewed.
    int height(TreeNode *root){
        if(!root)return 0;
        return 1+max(height(root->left),height(root->right));
    }
    bool isBalanced(TreeNode* root) {
        if(root==NULL)return true;
        return (abs(height(root->left)-height(root->right))<=1 &&
        isBalanced(root->left)&&
        isBalanced(root->right));
        
    }
};