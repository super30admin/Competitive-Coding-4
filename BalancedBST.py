'''
Solution
1.  Check whether BST is balanced or not using BST. Left Subtree should be balanced, Right Subtree should be balanced
    and difference of left height and right height should not exceed 1.

Time Complexity: O(nodes) and Space Complexity: O(1)

--- Passed all testcases on Leetcode successfully
'''


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BalancedBST(object):

    def __height(self, root):

        #   base case check
        if (root == None):
            return 0

        #   find left height and right height using recursion
        leftH = self.__height(root.left)
        rightH = self.__height(root.right)

        #   return the height of the root node
        return 1 + max(leftH, rightH)

    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #   base case check
        if (root == None or (root.left == None and root.right == None)):
            return True

        #   find left and right heights
        leftH = self.__height(root.left)
        rightH = self.__height(root.right)

        #   if difference is greater than 1, return False
        if (abs(leftH - rightH) > 1):
            return False

        #   call recursion on left subtree and right subtree
        return self.isBalanced(root.left) and self.isBalanced(root.right)