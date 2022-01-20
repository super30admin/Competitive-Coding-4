# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    # TC: O(N)
    # SC: O(H)
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        # Base
        if(root == None):
            return True
        
        # Logic
        return self.height(root) != -1
    
    def height(self, root):
        
        # Base
        if (root == None):
            return 0
        
        # Logic
        leftHeight = self.height(root.left)
        rightheight = self.height(root.right)
        
        if (abs(leftHeight - rightheight) > 1):
            return -1
        
        if (leftHeight == -1 or rightheight == -1):
            return -1
        
        return max(leftHeight, rightheight) + 1