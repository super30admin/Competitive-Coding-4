//
// Created by shazm on 7/27/2019.
//

#include <iostream>
#include <algorithm>
#include <bits/stl_vector.h>

// Runtime: O(n)
// Space: O(n)
// Approach: Add all elements in the LinkedList to a vector. After adding to vector, traverse through the vector and if
// the index is even, add from the beginning else add from the end.

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if(root == NULL){return true;}
        if(recurr(root)==-1){
            return false;
        }
        return true;
    }

    int recurr1(TreeNode* node){ //method1
        if(node == NULL){
            return 0;
        }

        int leftSize = recurr(node->left);
        int rightSize = recurr(node->right);

        if(leftSize == -1 || rightSize == -1 || abs(leftSize-rightSize)>1){
            return -1;
        }

        return max(leftSize+1,rightSize+1);
    }

    int recurr2(TreeNode* node){ //method2
        if(node->left == NULL && node->right == NULL){
            return 1;
        }

        int leftSize = 0; int rightSize = 0;

        if(node->left != NULL){
            leftSize= recurr(node->left);
        }

        if(node->right!=NULL){
            rightSize= recurr(node->right);
        }
        if(leftSize==-1 || rightSize == -1){
            return -1;
        }
        if(abs(leftSize-rightSize)>=0 && abs(leftSize-rightSize)<=1){
            return max(leftSize+1,rightSize+1);
        }
        return -1;
    }
};