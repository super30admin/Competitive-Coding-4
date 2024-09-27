/*
Time Complexity:
O(N) as we are traversing the tree only once
*/

/*
Space Complexity:
O(N) where N is the number of the nodes in the tree
This is the case if the tree is completely unbalanced
*/

/*
Approach:
To find if the tree is unbalanced we are using recursive technique here
We are first finding the height of left and right subtree and then
taking their difference. If the difference is greater than 1, it is not
balanced 

We had two techniques top down and bottom up to do this. In the top down
approach there was overhead of calculating the height for subtrees also.
But in the bottom up approach we use the height of the subtrees to find if
the subtrees and the current tree are balanced or not.
*/

//The code ran perfectly on leetcode


class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if(root == NULL) return true;
        return height(root) != -1;
        
    }
    
    private:
    int height(TreeNode* root){
        //base
        if(root== NULL) return 0;
        //logic
        int lh = height(root->left); //calculating the height of left subtree
        int rh = height(root->right);//calculating the height of right subtree
        if(abs(lh-rh)>1) return -1;
        if(lh == -1 || rh == -1) return -1;
        return max(lh, rh) +1;
    }
};