# Definition for a binary tree node.
#passed in leetcode
#time - O(n)\
#space - O(1)
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# a balanced subtree meaning left anf right subree have to be balanced and diff in height between left and right should be less than 1


class Solution(object):
    # lst = []
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not (root):
            return True
        return (self.isBalanced(root.left) and self.isBalanced(root.right) and abs(
            self.height_subtree(root.left) - self.height_subtree(root.right)) <= 1)

    # def height_subtree(self,root):

    def height_subtree(self, root):
        if not (root):
            return 0
        else:
            return max(self.height_subtree(root.left), self.height_subtree(root.right)) + 1








