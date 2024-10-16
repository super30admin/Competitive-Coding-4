#Approach
# Calculate the height of each node if any where the height difference is greayer than 1 then it is not binary tree

#Complexities
# Time O(N)
# Space: O(N)

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return (self.helper(root)>=0)


    def helper(self,root):
        if root is None:
            return 0

        leftheight  = self.helper(root.left)
        rightheight = self.helper(root.right)
        if leftheight < 0 or rightheight < 0 or abs(leftheight - rightheight) > 1:  return -1
        return max(leftheight, rightheight) + 1