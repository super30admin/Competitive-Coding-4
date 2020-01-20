Time complexity-O(n)
Space complexity-O(1) if recursive stack space is not considered or else it is O(h)
Did the code run on Leetcode? Yes

class Solution {
public:
    bool balancedheight(TreeNode* root, int &height)
    {
        if(root==NULL)
        {
            height=0;
            return true;
        }
        int leftheight=0;
        int rightheight=0;
        bool leftpart=balancedheight(root->left,leftheight);
        bool rightpart=balancedheight(root->right,rightheight);
        height=max(leftheight,rightheight)+1;
        if(abs(leftheight-rightheight)>1)
        {
            return false;
        }
        return leftpart&&rightpart;
    }
    
    bool isBalanced(TreeNode* root) {
        int height=0;
        return balancedheight(root,height);
    }
};