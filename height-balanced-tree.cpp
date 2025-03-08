// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

//Approach:
//1. We will use the recursive approach to find the height of the left and right subtree of the root node.
//2. If the height of the left subtree and the right subtree differ by more than 1, we will return -1.


class Solution {
    public:
        bool isBalanced(TreeNode* root) {
            if((dfs(root)) != -1){
                return true;
            }
            return false;
        }
    private: 
        int dfs(TreeNode* root){
            //base
            if(root == nullptr){
                return 0;
            }
    
            //logic
            int left = dfs(root -> left);
            if(left == -1){return -1;}
    
            int right = dfs(root -> right);
            if(right == -1){return -1;}
    
            if(abs(left - right) > 1){return -1;}
        return max(left, right) + 1;
        }
    };