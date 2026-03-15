#Balanced Binary Tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root) != -1

    def helper(self,root):

        if root == None:
            return 0

        leftHeight = self.helper(root.left)
        if leftHeight == -1:
            return leftHeight

        rightHeight = self.helper(root.right)
        if rightHeight == -1:
            return rightHeight

        if abs(abs(leftHeight-rightHeight) > 1):
            return -1

        return max(leftHeight, rightHeight) + 1
        