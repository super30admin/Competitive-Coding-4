#TC = O(nlogn)
#SC = O(n)
#Compiled and run on LC

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recur(self, root: TreeNode):
        if not root:
            return True, 0

        ltbal, ltht = self.recur(root.left)
        if not ltbal:
            return False, 0

        rtbal, rtht = self.recur(root.right)
        if not rtbal:
            return False, 0

        return (abs(ltht - rtht) < 2, 1 + max(ltht, rtht))

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return (self.recur(root)[0])