# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Space Complexity - o(n)
# Time Complexity - o(n)
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        if not root:
            return True
        
        def height(node):
            if not node:
                return 0
            left = height(node.left)
            right = height(node.right)
            diff = left - right
            if abs(diff)>1 or left==-1 or right == -1:
                return -1

            return 1 + max(height(node.left),height(node.right))

       

        return height(root)!=-1