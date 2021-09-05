//Time Complexity - O(N)
//Space Complexity - O(N)
class Solution {
public:
    bool optifunc(TreeNode* root, int &h){
        if(!root){
            h=0;
            return true;
        }
        int lh=0,rh=0;
        bool l,r;
        l = optifunc(root->left,lh);
        r = optifunc(root->right,rh);
        h = max(lh,rh)+1;
        if(abs(lh-rh)>=2)
            return false;
        return l && r;
    }
    bool isBalanced(TreeNode* root) {
        int h=0;
        return optifunc(root,h);
    }
};