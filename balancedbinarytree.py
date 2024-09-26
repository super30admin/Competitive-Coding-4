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
       
        #O(N)
        #O(h)
        def max_height(node):
            
            if node is None:
                return 0
            left_height = max_height(node.left)
            right_height = max_height(node.right)
            #return indefinite ans
            if left_height < 0 or right_height < 0:
                return -1

            if abs(left_height - right_height) <= 1:
                return 1 + max(left_height, right_height)
            #return indefinite ans
            return -1
        return max_height(root)!=-1
       
      
      
       
       
            
            