# // Time Complexity : o(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : could come up with the solution 


# // Your code here along with comments explaining your approach
# idea is to compare the left and right heights and based on that decide if the tree is balanced
# maintain a global pointer to iterate over the tree

# Definition for a binary tree node.

from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.isBalanced = True
        def helper(root):
            if not root : return 0
            left = helper(root.left)
            right = helper(root.right)
            if abs(left-right)>1:
                self.isBalanced = False
            return 1+max(left,right)
        helper(root)
        return self.isBalanced
        