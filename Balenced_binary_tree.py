# TC: O(N)
# SC: O(1)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    flag=True

    def helper(self, root):
        if root==None:
            return 0
        
        left =self.helper(root.left)
        right=self.helper(root.right)

        if left-right>1 or right-left>1:
            self.flag=False
    
        return 1+max(left,right)

    def isBalanced(self, root: Optional[TreeNode]) -> bool: 
        self.helper(root)
        return self.flag
        