// Time Complexity : O(N*N)
// Space Complexity :O(H) where H is height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if(root == NULL)
            return true;
        int left = height(root->left);
        int right = height(root->right);
        if(abs(left-right)>1)
            return false;
        return(isBalanced(root->left) && isBalanced(root->right));
    }
    int height(TreeNode* root){
        if(root == NULL){
            return 0;
        }
        return max(height(root->left), height(root->right)) + 1;
        
    }
};

// Time Complexity : O(N)
// Space Complexity :O(H) where H is height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        int height=0;
        return check(root, &height);
    }
    bool check(TreeNode* root, int *height){
        if(root == NULL){
            *height = 0;
            return true;
        }
        int lh=0, rh=0;
        bool left = check(root->left, &lh);
        bool right = check(root->right, &rh);
        *height = max(lh,rh) + 1;
        if(abs(lh-rh)>1)
            return false;
        else
            return left && right;
    }
};
