// Time Complexity : O(n)

// Space Complexity : O(h)

// Did this code successfully run on Leetcode : YES

// Appoarch: Traversed the left subtree and found the height,
// then right subtree and height and if diff is greater than 1
// returned false, else true.

//110. Balanced Binary Tree

#include <bits/stdc++.h>
using namespace std;

 // Definition for a binary tree node.
  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class Solution {
public:
    bool ans;
    int helper(TreeNode* root){
        if(root == NULL){
            return 0;
        }
        int left = helper(root->left);
        int right = helper(root->right);
        if(abs(left - right) > 1){
            ans = false;
        }
        return 1 + max(left,right);
    }
    bool isBalanced(TreeNode* root) {
        ans = true;
        int num = helper(root); 
        return ans;
    }
};