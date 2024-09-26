//Time complexity - O(n) n-number of nodes in tree
//Space complexity - O(h) h- height of the tree

class Solution {
public:
    bool ret = true;
    bool isBalanced(TreeNode* root) {
        if(root==NULL) return true;
        height(root);
        return ret;
    }
    
    int height(TreeNode* root){
        if(root==NULL || ret==false) return 0;
        int left = height(root->left);
        int right = height(root->right);
        if(abs(left-right)>1) ret = false;
        return 1+max(right,left);
    }
    
};