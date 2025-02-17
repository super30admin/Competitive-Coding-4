# Approach:
# Use recursion to check the height of each subtree; return -1 if any subtree is unbalanced.
# If the height difference between left and right subtrees is more than 1, propagate -1 up to indicate imbalance.
# Time & Space Complexity:
# Time Complexity: O(n) 
# Space Complexity: O(h)
class Solution:
    def checkHeight(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return 0
        left_height = self.checkHeight(root.left)
        if left_height == -1:
            return -1
        right_height = self.checkHeight(root.right)
        if right_height == -1:
            return -1
        if abs(left_height - right_height) > 1:
            return -1
        return 1 + max(left_height, right_height)
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.checkHeight(root) != -1