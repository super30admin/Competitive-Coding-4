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
  Time Complexity = O(N*N)
 Space Complexity = O(h)
 where N is the number of nodes in the tree and h is the height of the tree.
 */
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if(root==NULL)
            return true;
        return isBalanced(root->left) && isBalanced(root->right) && abs(height(root->left) - height(root->right))<=1;
    }
    int height(TreeNode* root)
    {
        if(root==NULL)
            return 0;
        return max(height(root->left),height(root->right))+1;
    }
};


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
 Time Complexity = O(N)
 Space Complexity = O(h)
 where N is the number of nodes in the tree and h is the height of the tree.
 */
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
