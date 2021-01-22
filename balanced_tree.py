# Time Complexity: O(N)
# Space Complexity: O(H)


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

        # base case 
        if not root:
            return True

        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(self.height(root.left) - self.height(root.right)) < 2
        
    
    def height(self, root):

        if not root:
            return -1

        return 1 + max(self.height(root.left), self.height(root.right))
