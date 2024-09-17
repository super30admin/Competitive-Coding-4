# 110. Balanced Binary Tree

# Code: Approach was to take the depth of Left subtree and right subtree, and compare if the difference was greater than 1 or not.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.maxDepth(root)!=None
    
        
    def maxDepth(self, root):
        if not root:
            return 0
        
        left = self.maxDepth(root.left)
        right = self.maxDepth(root.right)
        
        if left == None or right == None:
            return None
        
        if abs(left-right)>1:
            return None
        
        return max(left, right)+1
        
# Time complexity: O(N)
# Space complexity: O(1)
# Accepted on Leetcode: Yes