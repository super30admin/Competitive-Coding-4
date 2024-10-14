#110. Balanced Binary Tree
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
        return self.helper(root) != -1
    
    def helper(self,root): #T.C->O(N) , S.C->O(N)
        if(root == None): return 0

        left = self.helper(root.left)
        if left == -1:
            return -1
        right = self.helper(root.right)
        if right == -1:
            return -1
        if(abs(left-right)>1):
            return -1
        return 1 + max(left,right)