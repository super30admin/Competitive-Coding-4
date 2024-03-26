# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import TreeNode, Optional 
class Solution:
    def helper(self, root):
        if root is None:
            return 0
        leftValue = self.helper(root.left)
        rightValue = self.helper(root.right)

        # if parents is unbalanced, even children will be unbalanced
        if leftValue == -1 or rightValue == -1:
            return -1

        if abs(leftValue - rightValue ) > 1:
            return -1

        return 1 + max(leftValue, rightValue)

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        answer = self.helper(root)
        if answer != -1:
            return True
        return False