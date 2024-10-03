// time: O(n) space: O(n) recursion stack
class Solution {
public:
    bool flag = true;
    int helper(TreeNode* root) {
        if(root == NULL) {
            return 0;

        }
        int left = helper(root -> left);
        int right = helper(root -> right);
        if(abs(left-right) > 1) {
            flag = false;
            return 0;
        }
        return(max(left,right)+1);
    }
    bool isBalanced(TreeNode* root) {
        int temp = helper(root);
        return flag;
    }
};