"""
time - o(n)
space - o(1)
we recursively visit each node in the tree and pass on the depth as a parameter, we return the max depth between the left and right nodes, 
if at any point in the tree the difference between left and right depths are greater than 1 we make mark a global variable as false
"""
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        self.result = True
        self.helper(root, 0)
        return self.result

    def helper(self, root, depth):
        if not root:
            return depth
        
        left_depth = self.helper(root.left, depth+1)
        right_depth = self.helper(root.right, depth+1)
        if abs(left_depth-right_depth)>1:
            self.result = False
        return max(left_depth, right_depth)
        

        
        


        