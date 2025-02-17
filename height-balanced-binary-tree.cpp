/*The approach uses a recursive DFS (Depth-First Search) to calculate the height of the left and right subtrees for each node. 
It checks if the subtrees are balanced and calculates the height of the current subtree. 
If any subtree is unbalanced or the height difference between left and right is more than 1, it returns -1. 
If the height difference is within 1 for all nodes, it returns the actual height. 
Time complexity is O(n), where n is the number of nodes in the tree
Space complexity is O(h), where h is the height of the tree.*/
#include<bits/stdc++.h>
using namespace std;
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
    bool isBalanced(TreeNode* root) {
        if(root==NULL)return true;
        return height(root)!=-1;
    }
    private:
    int height(TreeNode* root){
        if(root==NULL)return 0;
        int left =height(root->left);
        int right =height(root->right);
        if(left ==-1||right==-1||abs(left-right)>1)return -1;
        return max(left,right)+1;
    }
};