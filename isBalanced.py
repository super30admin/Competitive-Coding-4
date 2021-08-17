"""
//Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
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
        # #T.C is O(nlogn)
        # if root == None:
        #     return True
        # if(abs(self.height(root.left)-self.height(root.right))>1):
        #     return False
        # return self.isBalanced(root.left) and self.isBalanced(root.right)
        
        
        #T.C == o(n)
        if root == None:
            return True
        return self.height(root)!=-1
    def height(self,root):
        if root is None:
            return 0
        lh = self.height(root.left)
      
        rh = self.height(root.right)
        
        if (abs(lh-rh)>1):
            return -1
        if (lh == -1 or rh == -1):
            return -1
        return 1 + max(lh,rh)