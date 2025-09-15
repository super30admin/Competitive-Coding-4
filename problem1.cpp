/* Height-Balanced Binary Tree */

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We write a helper function to calculate the height of the tree
// At every step, we calculate the height of the left & right subtrees and check if the diff > 1
// If we find an imbalance in any of the subtrees, we return -1, which is the sentinel value used to stop the recursion

class Solution {
private:
    int helper(TreeNode* root) {
        // base case:
        if(!root) return 0;
        // logic:
        int left = helper(root->left);
        if(left == -1) return -1;
        int right = helper(root->right);
        if(right == -1) return -1;

        if(abs(left - right) > 1) return -1;

        return 1 + max(left, right);
    }
public:
    bool isBalanced(TreeNode* root) {
        return helper(root) != -1;
    }
};