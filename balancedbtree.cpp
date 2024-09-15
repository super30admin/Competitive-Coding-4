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
 //T : O(n)
 //S : O(h) -  height of tree
class Solution {
public:
    int recurr = 0;
    int getHeight(TreeNode* root){
        if(!root) return 0;
        int left = getHeight(root->left);
        int right = getHeight(root->right);
        recurr = recurr+1;
        //cout<<"Recurr count "<<recurr<<" "<<left<<" "<<right<<endl;
        return max(left, right) + 1;
    }
    
    
    bool isBalanced(TreeNode* root) {
        if(!root) return true;
        int left = getHeight(root->left);
        int right = getHeight(root->right);
        int ab = abs(left-right);
        if(ab<=1){
            return isBalanced(root->left) && isBalanced(root->right);
        }
        //cout<<left<<" "<<right<<endl;
        return false;
    }
};