# // Time Complexity : O(n) where n is the number of treenodes in the given tree
# // Space Complexity : O(h) where h is the height of the tree 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True
    def dfs(self,root):
        if not root: return 0
        left = self.dfs(root.left)
        right = self.dfs(root.right)
        if abs(left-right) > 1: self.flag = False
        return 1 + max(left,right)
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        # self.flag = True
        
        self.dfs(root)
        
        return self.flag