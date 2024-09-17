// Time Complexity : O(n)
// Space Complexity :  O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
public:
    int ht_bal(TreeNode* root)
    {
        if(root == NULL)
           return 0;
           
        int h1, h2, diff;

        // Find Left Subtree height        
        h1 = ht_bal(root->left);
        
        if(h1 < 0)
            return -1;
        
        // Find Right subtree height
        h2 = ht_bal(root->right);
        
        if(h2 < 0)
            return -1;
        
        diff = abs(h1 - h2);
        
        // Favorable case
        if(diff <= 1)
            return (1 + max(h1, h2));
        else
            return -1;
    }
    
    bool isBalanced(TreeNode* root) {
        
        int res = ht_bal(root);
        
        if(res < 0)
            return false;
        else
            return true;
    }
};