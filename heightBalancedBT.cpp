#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
/*
Using a recursive helper function to check the height of the tree and 
to check if the depth is 0 or 1 and if it is greater than 1 we change the flag 
and return the result
*/
class Solution{
public:
    bool flag = false;
    bool isBalanced(TreeNode* root){
        flag = true;
        helper(root);
        return flag;
    }
private: 
    int helper(TreeNode* root){
        if(!root) return 0;
        int left = 0, right = 0;

        if(flag) left = helper(root->left) + 1;
        if(flag) right = helper(root->right) + 1;
        if(abs(left - right) > 1) flag = false;

        return max(left, right);
    }
};
