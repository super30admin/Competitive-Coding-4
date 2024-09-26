#Time Complexity : O(N) where N is the number of Nodes
#Space Complexity : O(H) where H is the height of the Tree
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
        def height(root):
            if root == None:
                return 0
            else:
                return max(height(root.left),height(root.right)) +1
        if root == None:
            return True
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(height(root.left) - height(root.right)) <=1
       
        

        