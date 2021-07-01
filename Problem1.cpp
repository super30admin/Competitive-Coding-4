// Time Complexity : O(n^2) BFS, O(n) using DFS
// Space Complexity : O(h) height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 


// Height Balanced Tree

#include<vector>
#include<iostream>
#include<queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


// Using BFS 

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        
       queue<TreeNode*> q1;     //queue for BFS
        
        int heightLeft = 0;
        int heightRight = 0;
        if(root == NULL)
            return true;
        
        if(root->left == NULL)
            heightLeft = 0;
        else{
            // calculate the height of my left subtree
            TreeNode* rootL = root->left;
            
            q1.push(rootL);
            
            while(!q1.empty()){
                
                int sizeL = q1.size();
                
                while(sizeL > 0){
                    // push the rest of the children into the queue
                    TreeNode *tempL = q1.front();
                    q1.pop();
                    if(tempL->left)
                        q1.push(tempL->left);
                    if(tempL->right)
                        q1.push(tempL->right);
                    
                    sizeL--;
                }
                
                heightLeft++;   // after each level   
            }
        }
            
        if(root->right == NULL)
            heightRight = 0;
        else{
            // calculate the height of my right subtree
             TreeNode* rootR = root->right;
            
            q1.push(rootR);
            
            while(!q1.empty()){
                
                int size = q1.size();
                
                while(size > 0){
                    // push the rest of the children into the queue
                    TreeNode *tempR = q1.front();
                    q1.pop();
                    if(tempR->left)
                        q1.push(tempR->left);
                    if(tempR->right)
                        q1.push(tempR->right);
                    
                    size--;
                }
                
                heightRight++;   // after each level   
            }
        }
        
        
        if(abs(heightLeft - heightRight) <= 1)
            return isBalanced(root->left) && isBalanced(root->right);
        
        else 
            return false;
        
        
    }
};

// DFS

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        
        if(root == NULL)
            return true;
        
        int leftHeight = height(root->left);
        int rightHeight = height(root->right);
        return ((abs(leftHeight - rightHeight) <= 1) && isBalanced(root->left) && isBalanced(root->right)); 
    }
    
    int height(TreeNode* root)
    {
        if(root == NULL)
            return 0;
        return max(height(root->left), height(root->right))+1;
    }
};