# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    flag = True
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.helper(root)
        return self.flag

    def helper(self, root):
        if not root:
            return 0

        left = 1+ self.helper(root.left)
        right = 1+self.helper(root.right)

        if abs(left-right)>1:
            self.flag = False

        return max(left,right)
        