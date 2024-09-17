"""
// Time Complexity : o(n), n-> number of nodes
// Space Complexity : o(h), h->height of tree
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def height(self,root): #function to find the height of the tree at each node
        if not root:
            return 0
        right = self.height(root.right) + 1
        left = self.height(root.left) + 1
        
        return max(left,right) #height at a node is maximum the max of height of its left and right subtrees 
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        
        left_height = self.height(root.left)
        right_height = self.height(root.right)
        
        if abs(left_height - right_height) >1: #if difference in height is greater than 1 for any subtree, return false
            return False
        
        return self.isBalanced(root.left) and self.isBalanced(root.right)
        
        