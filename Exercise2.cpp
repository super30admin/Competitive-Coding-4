// Problem - Balanced binary tree
//  Time Complexity : O(n)
//  Space Complexity : O(n) where n is the height of the tree
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Explaination
// 1. Here we do int based recursion, we get the height of the left subtree and
// right subtree, from leaf we  return 0
// 2. Every time we return the max of left subtree height and right subtree
// height
// 3. At any point if the betwen difference these two heights is greater than 1
// we turn the flag false and since it is conditional recursion it won't do
// further recursive calls

#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};
class Solution {
public:
  bool flag = true;
  bool isBalanced(TreeNode *root) {
    helper(root);
    return flag;
  }

  int helper(TreeNode *root) {
    // base
    if (root == nullptr) {
      return 0;
    }
    if (!flag)
      return 0;
    // logic
    int lh = 1 + helper(root->left);
    int rh = 1 + helper(root->right);
    if (abs(lh - rh) > 1) {
      flag = false;
    }
    return max(lh, rh);
  }
};
