#LC 110 - Balanced Binary Tree
#Time Complexity - O(n)
#Space Complexity - O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        
        def getHeight(root):
            if not root:
                return -1
            left = getHeight(root.left)
            right = getHeight(root.right)
            if left == 9999 or right == 9999:
                return 9999
            if abs(left - right) > 1:
                return 9999
            return max(left,right)+1
        
        if getHeight(root) == 9999:
            return False
        return True