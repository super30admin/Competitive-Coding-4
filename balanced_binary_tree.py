# Time Complexity: O(n) 
# Space Complexity: O(h) where h is the height of tree and stack space for recursion
# Ran on Leetcode: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.balanced = True
        
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        self.helper(root)
        return self.balanced
    
    def helper(self, root):
        if not root:
            return 0
        l = self.helper(root.left)
        r = self.helper(root.right)
        if l == -1 or r == -1:
            return -1
        if abs(l - r) > 1:
            self.balanced = False
            return -1
        return max(l,r) + 1