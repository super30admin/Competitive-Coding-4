""""// Time Complexity : O(n)
// Space Complexity : O(h), h-height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.flag = True

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.helper(root)
        return self.flag

    def helper(self, root):
        if not root:
            return 0
        leftheight = self.helper(root.left) + 1
        rightheight = self.helper(root.right) + 1

        if abs(leftheight - rightheight) > 1:
            self.flag = False
        return max(leftheight, rightheight)

