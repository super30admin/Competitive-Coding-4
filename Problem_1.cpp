// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Balanced Binary Tree
// Approach: DFS
// Time Complexity: O(n)
// Space Complexity: O(h)

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
class Solution
{
public:
    bool isBalanced(TreeNode *root)
    {

        // Base Case
        if (root == NULL)
        {
            return true;
        }

        // Check for response from recursive function and accordingly retun the result
        if (dfs(root) == -1)
        {
            return false;
        }

        return true;
    }

    int dfs(TreeNode *root)
    {

        // Base Case
        if (root == NULL)
        {
            return 0;
        }

        // Continue DFS on Childs
        int left = dfs(root->left);
        int right = dfs(root->right);

        // If one of them is not balanced return -1
        // If not check for difference between the child heights
        if (left == -1 || right == -1 || abs(left - right) > 1)
        {
            return -1;
        }

        // If all satisfies return the height of the sub-tree to the parent
        return max(left, right) + 1;
    }
};