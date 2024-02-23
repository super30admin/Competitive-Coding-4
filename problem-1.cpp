// 110. Balanced Binary Tree
// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
uses a recursive helper function to calculate the height of each subtree, and at each node, 
checks if the height difference between its left and right subtrees exceeds one, setting a flag accordingly.

*/

class Solution {
public:
    bool flag = true;
    bool isBalanced(TreeNode* root) {
        int height = helper(root);
        return flag;
    }
    int helper(TreeNode* root)
    {
        if(root == NULL)
            return 0;
        if(root->right == NULL && root->left == NULL)
            return 1;
        int left = helper(root->left);
        int right = helper(root->right);
        if(abs(left - right) > 1)
            flag = false;
        return max(left,right) + 1;
    }
};
