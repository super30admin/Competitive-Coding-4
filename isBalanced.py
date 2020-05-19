# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity:O(n)
#Space COmplexity:O(1)

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        
        if not root :
            return True
        return abs(self.getHeight(root.left)-self.getHeight(root.right))<2 and self.isBalanced(root.left) and self.isBalanced(root.right)
     


    def getHeight(self, root):
        if not root:
            return 0

        return 1 + max(self.getHeight(root.left), self.getHeight(root.right))
