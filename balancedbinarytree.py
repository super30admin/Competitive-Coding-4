# Time Complexity : O(n)
# Space Complexity : O(h), h --> height of the Tree.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.flag = True

    def helper(self, root):
        if not root:
            return 0
        left_count = self.helper(root.left)
        right_count = self.helper(root.right)
        if abs(left_count - right_count) > 1:
            self.flag = False
            return 0
        return 1 + max(left_count, right_count)

    def isBalanced(self, root) -> bool:
        self.helper(root)
        return self.flag


check = TreeNode(7)
check.left = TreeNode(3)
check.right = TreeNode(15)
check.right.left = TreeNode(9)
check.right.right = TreeNode(20)
print(Solution().isBalanced(check))
