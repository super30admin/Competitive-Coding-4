// Time complexity is O(n) - #nodes in the binary tree
// Space complexity is O(h) - h = height of the tree (when it is a skewed tree: h = n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
/*
    1. When node is NULL, height = 0. So, height of a leaf node will be 1.
    2. At any node, I calculate the height of left subtree and height of right subtree.
    3. If the absolute difference of the left sub-tree height and right sub-tree height
       is greater than 1, we can say that the tree is not balanced.
 */

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
class Solution {
public:
    int helper(TreeNode* root) {
        //base
        if(root == nullptr) return 0;
        
        //logic
        int leftSubtreeHeight = helper(root->left);
        
        int rightSubTreeHeight = helper(root->right);
        
        if((leftSubtreeHeight == -1 || rightSubTreeHeight == -1)  || abs(leftSubtreeHeight-rightSubTreeHeight) > 1) {
            return -1; // false;
        }
        return max(leftSubtreeHeight, rightSubTreeHeight)+1; // true;
        
    }
    bool isBalanced(TreeNode* root) {
        if(root == nullptr) return true;
        if( helper(root) == -1) {
            return false;
        }
        else {
            return true;
        }
    }
};
