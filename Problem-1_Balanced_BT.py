# APPROACH  
# Time Complexity : O(n), n: number of nodes of BT
# Space Complexity : O(h), h: height of Binary Tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None (the base case and the return value)
#
#
# Your code here along with comments explaining your approach
# 1. if root is None, return 0
# 2. else call the function on it's left and right. If it's invalid return -1 (keep returning everywhere) else return max of height of both subtrees
# 3. At current node, inc. by 1 (to consider the current node)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        
        if root is None:
            return True
        
        if self.helper(root) == -1:
            return False
        else:
            return True
        
   
    def helper(self, root):
        if root is None:
            return 0
        
        left = self.helper(root.left)
        if left == -1:
            return -1
        else:
            left += 1
            
        right = self.helper(root.right)
        if right == -1:
            return -1
        else:
            right += 1
            
        if abs(left - right) <= 1:
            return max(left, right)
        else:
            return -1
        
