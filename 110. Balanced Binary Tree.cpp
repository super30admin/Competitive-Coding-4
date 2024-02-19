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
    bool balanced;

    /*
    Time: O(N)
    Space: O(H) (Recursive stack space = Height of the tree)

    For every node, check the longest node to left path for its left and right subtree
    If their difference is <= 1, continue traversing
    If difference is > 1, prune the tree and return false
    */
    int call(TreeNode* r){
      if(r==nullptr)  return 0;

      int left_h = call(r->left);

      //prune tree if balance is breached
      if(balanced == false)  return -1; 

      int right_h = call(r->right);

      //absolute difference cannot exceed 1
      if(abs(left_h - right_h) > 1)  balanced = false;

      //height = height of larger subtree + 1 for this node itself
      return max(left_h, right_h) + 1;
    }

    bool isBalanced(TreeNode* root) {
        balanced = true;
        call(root);

        return balanced;
    }
};
