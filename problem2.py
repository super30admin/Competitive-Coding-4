# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root==None or (root.right == None and root.left == None):
            return True
        height1 = self.height(root.left)
        height2 = self.height(root.right)

        if abs(height1 - height2) > 1:
            invalid = False
        else:
            invalid = True

        value1 = self.isBalanced(root.left)
        value2 = self.isBalanced(root.right)

        return value1 and value2 and invalid

    def height(self,root):
        if root == None:
            return -1
        if root.left == None and root.right == None:
            return 0
        val = 1 + max(self.height(root.left),self.height(root.right))
        return val

        
