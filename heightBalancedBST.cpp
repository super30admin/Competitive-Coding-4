class Solution {
    // TC -O(n)
    // SC - O(n)
public:
    bool isBalanced(TreeNode* root) {

     int val =  isHeightBalanced(root);
     if(val<0) return false;
     else return true;
        
    }

    int isHeightBalanced(TreeNode* root){
        if(root == NULL)  return 0;
        
       int leftTreeHeight =  1+isHeightBalanced(root->left);
       if(leftTreeHeight <0) return INT_MIN; // to stop further traversal

       int rightTreeHeight = 1+isHeightBalanced(root->right);
       if(rightTreeHeight <0) return INT_MIN; // // to stop further traversal

       if(abs(leftTreeHeight - rightTreeHeight ) > 1) return INT_MIN; 
       else return max (leftTreeHeight, rightTreeHeight);

    }
};