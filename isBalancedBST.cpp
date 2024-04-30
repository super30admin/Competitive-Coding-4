//Time O(n)
 //Space O(n)
 //Leetcode yes
 //issue seen: none
class Solution {
public:
    bool flag = true;
    int dfs(TreeNode* root){
        if(!root) return 0;
        if(!root->left && !root->right){
            return 0;
        }
        int Hleft=0;
        if(root->left){
           Hleft = 1 + dfs(root->left);
        }
        int Hright=0;
        if(root->right){
           Hright = 1 + dfs(root->right);
        }
        if(abs(Hright - Hleft) > 1){
            flag = false;
        }
       return(max(Hleft, Hright));
    }
    bool isBalanced(TreeNode* root) {
        if(!root) return true;
        dfs(root);
        return flag;
        
    }
};
