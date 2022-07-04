# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    '''Time Complexity: O(nlogn)
    Space Complexity: O(1)'''
    
    def height(self,root):
        if not root:
            return 0
        else:
            hl=self.height(root.left)
            hr=self.height(root.right)
            return 1 + max(hl, hr)
    
        
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        diff= abs(self.height(root.left)-self.height(root.right))
        return diff <=1 and self.isBalanced(root.left) and self.isBalanced(root.right)
        
