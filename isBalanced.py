# Time Complexity: O(n)
# Space Complexity: O(n)
# The program ran successfully run on Leetcode

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        if self.height(root) != -1:
            return True
        else:
            return False

    def height(self, root):
        if root is None:
            return 0

        left = self.height(root.left)
        right = self.height(root.right)

        if abs(left - right) > 1:
            return -1
        if left == -1 or right == -1:
            return -1
        return max(left, right) + 1

