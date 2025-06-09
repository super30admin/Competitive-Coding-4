#Time Complexity: O(N)
#Space Complexity: O(h) -> Height of the tree


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        def getDepth(root):
            if root is None:
                return 0
            ldep = getDepth(root.left)
            if ldep == -1:
                return -1
            rdep = getDepth(root.right)
            if rdep == -1:
                return -1
            if abs(ldep - rdep) > 1:
                return -1
            return 1 + max(ldep,rdep)
        return getDepth(root) != -1