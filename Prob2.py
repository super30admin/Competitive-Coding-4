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
        if root is None:
            return True
        #bottom up recursive approach
        def height(root):
            #base
            if root is None:
                return 0
            #logic
            left = height(root.left)
            right = height(root.right)
            #if difference is greater than 1, return -1 as the height up
            if abs(left-right) >1:
                return -1
            # in case one of the height on the left is -1 or on the right is -1, propagate that
            if left == -1 or right == -1:
                return -1
            # if not just propagate the height
            return max(left,right)+1
        #if -1 is propagated till the root, then unbalanced somewhere down
        return height(root) != -1