
class Solution {
	public:
    bool isBalanced(TreeNode* root) {
			if(root == NULL)return true; // If the root is null, there is no tree. Hence balanced.
            
			return isBalanced(root->left) && isBalanced(root->right) &&  abs(height(root->left) - height(root->right)) <= 1;
        //Now if root is not null, we check for left and right subtrees and also the absolute height difference between left and right should be less than 1 for the tree to be balanced.
        
		}
		int height(TreeNode *root) {    // Function to calculate the height diff between the left and right child nodes.
			if(root == NULL)return 0;
			return max(height(root->left), height(root->right)) + 1;
		}
		
    
    
};