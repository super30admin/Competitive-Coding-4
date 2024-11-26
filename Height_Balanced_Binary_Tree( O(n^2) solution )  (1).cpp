Time Complexity-O(n^2) as each time we are visiting all of the node's children to calculate the height.
Space Complexity-O(1) if recursive stack space is not considered or else it is O(h)
Did the code run on Leetcode? yes

class Solution {
public:
     int findheight(TreeNode* root)
     {
         if(root==NULL)
         {
             return 0;
         }
         return max(findheight(root->left),findheight(root->right))+1;
     }
    
    bool isBalanced(TreeNode* root) {
        if(root==NULL)
        {
            return true;
        }
        int leftheight=findheight(root->left);
        int rightheight=findheight(root->right);
        if(abs(leftheight-rightheight)>1)
        {
            return false;
        }
        return isBalanced(root->left)&&isBalanced(root->right);
     
    }
};