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
        if root==None:
            return True
        def height(root):
            if root==None:
                return 0
            return max(height(root.left),height(root.right))+1
        return self.isBalanced(root.right) and self.isBalanced(root.left) and abs(height(root.left)-height(root.right))<=1

    #time-O(n) space=O(n)