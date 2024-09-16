/*

// Time Complexity : O(N) all elements of the node
// Space Complexity : O(H) height of the tree used in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Edge case where internal trees could be unbalanced


// Your code here along with comments explaining your approach
For each node try to find the level of left subtree and right subtree
if abs(lefr - right) > 1 flag = false else flag = true;

*/







#include<iostream>
#include<math.h>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


class Solution {
    bool flag{true};
    int helper(TreeNode* root){
        if(root == NULL || flag == false) return 0;
        int cnt1 = 1 + helper(root->left);
        int cnt2 = 1 + helper(root->right);
        if(flag && abs(cnt1 - cnt2)>1) flag = false;
        return max(cnt1,cnt2);
    }
public:
    bool isBalanced(TreeNode* root) {
        if(root == NULL) return true;
        int cnt1 = helper(root->left);
        int cnt2 = helper(root->right);
        if(flag == false || abs(cnt1-cnt2)>1) return false;
        return true;
    }
};


/*

somewhat works

class Solution {

    int helper(TreeNode* root){
        if(root == NULL) return 0;
        int cnt1 = 1 + helper(root->left);
        int cnt2 = 1 + helper(root->right);
        return max(cnt1,cnt2);
    }
public:
    bool isBalanced(TreeNode* root) {
        if(root == NULL) return true;
        int cnt1 = helper(root->left);
        int cnt2 = helper(root->right);
        if(abs(cnt1-cnt2)>1) return false;
        return true;
    }
};

fail if internal trees are not balanced
[1,2,2,3,NULL,NULL,3,4,NULL,NULL,4]

*/