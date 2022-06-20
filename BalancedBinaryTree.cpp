// Time Compeleity - O(n^2) - since we are calculating the height at each node.
// Space Compelxity - o(n^2)
// Runs on Leetcode!
class Solution {
    private:
    int height(TreeNode* node){
        if(!node)
            return 0;
        int lH = height(node->left);
        int rH = height(node->right);
        int h = max(lH, rH);
        return 1 + h;
    }

public:
    bool isBalanced(TreeNode* root) {
        if(!root)
            return true;
        int lH = height(root->left);
        int rH = height(root->right);
        if(abs(lH - rH) >1)
            return false;
        return isBalanced(root->left) && isBalanced(root->right);
    }
};

// BottomUp approach
// Time Complexity - O(n).
// Pending - Visualize how this is bottom up  <--<--<--<--<--<--<--<--<--<--<--<----
class Solution {
    private:
    int factor(TreeNode* node){
        if(!node)
            return 0;
        int l = factor(node->left);
        int h = factor(node->right);
        int fac = abs(l - h);
        if(fac > 1 || l == -1 || h == -1)
            return -1;
        return 1 + max(l, h);
    }
public:
    bool isBalanced(TreeNode* root) {
        if(!root)
            return true;
        int answer = factor(root);
        if(answer == -1)
            return false;
        else return true;
    }
};